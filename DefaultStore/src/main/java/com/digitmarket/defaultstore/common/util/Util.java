package com.digitmarket.defaultstore.common.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Util {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	

	/**
	 * Copies a file using the File streams
	 * 
	 * @param source
	 * @param dest
	 */
	public static void copyFileUsingStream(File source, File dest) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} catch (Exception ex) {
			System.out.println("Unable to copy file:" + ex.getMessage());
		} finally {
			try {
				is.close();
				os.close();
			} catch (Exception ex) {
			}
		}
	}

}
