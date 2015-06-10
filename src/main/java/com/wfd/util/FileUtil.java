/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wfd.util;

import java.io.File;
import java.io.InputStream;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author user
 */
public class FileUtil {
    
    public static void writeToFile(InputStream in, String filePath){
        try{
            byte [] data = IOUtils.toByteArray(in);
            FileUtils.writeByteArrayToFile(new File(filePath),data);
            IOUtils.closeQuietly(in);
        }catch(Exception e){
            System.out.println("Failed to conver inputstream to an image in server.");
            e.printStackTrace();
        }
    }
    
}
