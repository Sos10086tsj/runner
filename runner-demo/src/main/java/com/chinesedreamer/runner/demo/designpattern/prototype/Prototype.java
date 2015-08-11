package com.chinesedreamer.runner.demo.designpattern.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**  
* Description: native，性能比new好。与单例冲突，默认浅拷贝。
* @author Paris    
* @date Aug 10, 2015
* @version 1.0
*/
public class Prototype implements Cloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6339263932593362959L;
	
	private @Getter @Setter String string;
	private @Getter @Setter SerializableObject obj;
	
	/**
	 * 浅拷贝
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Object clone() throws CloneNotSupportedException{
		Prototype prototype = (Prototype)super.clone();
		return prototype;
	}
	
	/**
	 * 深拷贝
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public Object deepClone() throws IOException, ClassNotFoundException{
		/* 写入当前对象的二进制流 */
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		 /* 读出二进制流产生的新对象 */  
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());  
        ObjectInputStream ois = new ObjectInputStream(bis);  
        return ois.readObject();
	}
	
	class SerializableObject implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 4457075091674418667L;
		
	}
	
}
