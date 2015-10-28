package com.cloudcar.common.json;

public class AlterKey {

	private final boolean	shouldIgnore;

	private final boolean	isLeaf;

	private final String	keyValue;

	private final String	origKeyStr;

	public AlterKey( boolean shouldIgnore, boolean isLeaf, String keyValue, String origKeyStr ) {
		this.shouldIgnore = shouldIgnore;

		this.isLeaf = isLeaf;

		this.keyValue = keyValue;

		this.origKeyStr = origKeyStr;
	}

	public boolean isShouldIgnore() {

		return shouldIgnore;
	}

	public boolean isLeaf() {

		return isLeaf;
	}

	public String getKeyValue() {

		return keyValue;
	}

	public String getOrigKeyStr() {

		return origKeyStr;
	}

	public AlterKey updateKey( String prefix ) {

		String newKeyValue = this.keyValue.startsWith( prefix ) ? this.keyValue.substring( prefix.length() )
				: this.keyValue;

		// Remove the left delimit '.' if need.
		if ( !newKeyValue.isEmpty() ) {
			newKeyValue = newKeyValue.substring( 1 );
		}

		return new AlterKey( shouldIgnore, isLeaf, newKeyValue, origKeyStr );
	}
}
