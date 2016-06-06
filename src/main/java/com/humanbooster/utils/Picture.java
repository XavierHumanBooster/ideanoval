package com.humanbooster.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Picture {
	
	public static String getFileExtension(String NomFichier) {
		File tmpFichier = new File(NomFichier);
		tmpFichier.getName();
		int posPoint = tmpFichier.getName().lastIndexOf('.');
		if (0 < posPoint && posPoint <= tmpFichier.getName().length() - 2) {
			return tmpFichier.getName().substring(posPoint + 1);
		}
		return "";
	}

	public static void copyFile(File src, File dest) throws IOException {
		InputStream in = new BufferedInputStream(new FileInputStream(src));
		OutputStream out = new BufferedOutputStream(new FileOutputStream(dest));
		byte[] buf = new byte[4096];
		int n;
		while ((n = in.read(buf, 0, buf.length)) > 0)
			out.write(buf, 0, n);

		in.close();
		out.close();
	}

}
