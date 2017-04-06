/**
 * 
 */
/**
 * @author admin
 *
 */
package com.petapplication.utility;

import java.io.Serializable;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;

public class ModelBase implements Serializable{

	public String toString(){
		return ReflectionToStringBuilder.toString(this);
	}
}