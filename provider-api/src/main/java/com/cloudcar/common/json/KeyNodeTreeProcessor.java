package com.cloudcar.common.json;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum KeyNodeTreeProcessor {
	INSTANCE;

	private static final String		MODIFIED_KEY_PATTERN	= "^(.+)(#)((\\([iIlL]{1,2}?\\))?)$";

	private static final Pattern	ALTER_KEY_PATTERN		= Pattern.compile( MODIFIED_KEY_PATTERN );

	public KeyTreeNode buildKeyTree( Properties properties ) {

		KeyTreeNode root = new KeyTreeNode( "" );

		properties.forEach( ( key, value ) -> {

			AlterKey alterKey = parseAlterKey( value.toString() );
			insertKey( root, key.toString(), alterKey );

		} );

		return root;

	}

	private void insertKey( KeyTreeNode root, String key, AlterKey alterKey ) {

		String[] keyNodes = key.split( "\\." );
		for ( int i = 0; i < keyNodes.length; i++ ) {
			String nodeValue = keyNodes[i];

			// We may have key as like key[3], this is not an array but a single element
			boolean isArray = nodeValue.endsWith( "[]" );
			if ( isArray ) {
				// remove the array sign;
				nodeValue = nodeValue.substring( 0, nodeValue.length() - 2 );
			}

			KeyTreeNode child = root.findChild( nodeValue );
			if ( child == null ) {
				child = new KeyTreeNode( nodeValue, false, false, isArray );
				root.addChild( child );
			}

			root = child;
		}

		// Root becomes last element now.
		root.setAlterKey( alterKey );
	}

	public List<String> convertKeys( KeyTreeNode root ) {

		List<String> result = new ArrayList<String>();

		convertKeysInternal( root, result, new ArrayList<String>() );

		return result;
	}

	private void convertKeysInternal( KeyTreeNode root, List<String> result, ArrayList<String> keyComponents ) {

		keyComponents.add( root.getValue() );

		if ( root.getChildren().isEmpty() || root.isDeleted() || root.isLeave() ) {
			String key = concateString( keyComponents );
			result.add( key );
		} else {
			root.getChildren().values().forEach( child -> {
				convertKeysInternal( child, result, keyComponents );
			} );
		}

		// remove the last one;
		keyComponents.remove( keyComponents.size() - 1 );

	}

	public KeyTreeNode buildKeyTree( List<String> keys ) {

		if ( keys == null || keys.isEmpty() ) {
			return null;
		}

		KeyTreeNode head = new KeyTreeNode( "^$" );

		keys.forEach( key -> {
			// key.matches(regex)
		} );

		return head;
	}

	public void process( KeyTreeNode root, String key, String delimiter ) {

		process( root, key, delimiter, false, false );
	}

	public void process( KeyTreeNode root, String key, String delimiter, boolean isLeave, boolean isDelete ) {

		String[] keyNodes = key.split( delimiter );
		for ( int i = 0; i < keyNodes.length; i++ ) {
			String nodeValue = keyNodes[i];

			boolean isArray = nodeValue.endsWith( "[]" );
			if ( isArray ) {
				// remove the array sign;
				nodeValue = nodeValue.substring( 0, nodeValue.length() - 1 );
			}

			boolean isLast = i == keyNodes.length - 1;

			KeyTreeNode child = root.findChild( nodeValue );
			if ( child == null ) {
				child = new KeyTreeNode( nodeValue, isLast || isLeave, isLast || isDelete, isArray );
				root.addChild( child );
			} else if ( isLast && ( isLeave || isDelete ) ) {
				// remove all pre-add child is current child is minded to be delete or a child
				child.getChildren().clear();
			}

			// don't go further is a node is arbitrary set as leave
			// or it should be deleted.
			if ( child.isDeleted() || child.isLeave() ) {
				break;
			}

			root = child;
		}
	}

	protected String concateString( List<String> data ) {

		if ( data == null || data.isEmpty() ) {
			return null;
		}

		StringBuilder builder = new StringBuilder( "" );

		data.forEach( value -> {
			builder.append( "." ).append( value );
		} );

		builder.deleteCharAt( 0 );

		return builder.toString();
	}

	public AlterKey parseAlterKey( String keyStr ) {

		if ( keyStr == null || !keyStr.matches( MODIFIED_KEY_PATTERN ) ) {
			throw new InvalidParameterException(
					"Passing key string is either null or not consistent with alter key format" );
		}

		Matcher m = ALTER_KEY_PATTERN.matcher( keyStr );

		m.find();

		String keyValue = m.group( 1 );
		// String keyValue = key.substring( key.lastIndexOf( '.' ) + 1 );

		String flags = m.group( 3 );
		boolean shouldIgnore = flags == null ? false : flags.contains( "i" ) || flags.contains( "I" );
		boolean isLeaf = flags == null ? false : flags.contains( "l" ) || flags.contains( "L" );

		return new AlterKey( shouldIgnore, isLeaf, keyValue, keyStr );
	}
}
