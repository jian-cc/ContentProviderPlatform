package com.cloudcar.common.json;

import java.util.HashMap;
import java.util.Map;

public class KeyTreeNode {

	private final String					value;

	private final Map<String, KeyTreeNode>	children;

	private final boolean					isDeleted;

	private final boolean					isLeave;

	private final boolean					isArray;

	private AlterKey						alterKey;

	public KeyTreeNode( String value ) {
		this( value, false, false, false );
	}

	public KeyTreeNode( String value, boolean isLeave, boolean isDeleted, boolean isArray ) {
		this.value = value;
		this.isLeave = isLeave;
		this.isDeleted = isDeleted;
		this.isArray = isArray;

		children = new HashMap<String, KeyTreeNode>();
	}

	public String getValue() {

		return value;
	}

	public boolean isLeave() {

		return alterKey != null;
	}

	public Map<String, KeyTreeNode> getChildren() {

		return children;
	}

	public void addChild( KeyTreeNode child ) {

		children.put( child.getValue(), child );
	}

	public boolean isDeleted() {

		return isDeleted;
	}

	public KeyTreeNode findChild( String key ) {

		return children.get( key );
	}

	public boolean isArray() {

		return isArray;
	}

	public AlterKey getAlterKey() {

		return alterKey;
	}

	public void setAlterKey( AlterKey alterKey ) {

		this.alterKey = alterKey;
	}

	public KeyTreeNode update( String prefix ) {

		KeyTreeNode root = new KeyTreeNode( value, isLeave, isDeleted, isArray );
		if ( this.getAlterKey() != null ) {
			root.setAlterKey( this.alterKey.updateKey( prefix ) );
		}

		this.getChildren().forEach( ( key, childNode ) -> {
			KeyTreeNode childRoot = childNode.update( prefix );
			root.getChildren().put( key, childRoot );
		} );

		return root;
	}
}
