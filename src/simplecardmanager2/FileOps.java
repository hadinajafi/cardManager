/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecardmanager2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Hadi Najafi
 */
public class FileOps implements FileOperations {

    private File file;
    private String root;
    private String fileName;
    private Properties data;

    public FileOps() {
        data = new Properties();
        root = System.getProperty("user.home") + "/.SimpleCardManager/";
        createAppDirectories();
    }
    @Override
    public Properties getData() {
        readData();
        return data;
    }

    @Override
    public void setData(Properties data) {
        this.data = data;
    }

    @Override
    public void writeData() {
        file = new File(root + fileName);
        try {
            FileWriter writer = new FileWriter(file);
            data.store(writer, null);
            writer.close();
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void readData() {
        file = new File(root + fileName);
        FileReader reader;
        try {
            reader = new FileReader(file);
            data.load(reader);
            reader.close();
        } catch (FileNotFoundException ex) {
            System.err.println(ex.getMessage());
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
        
    }
    
    public String[] getAllFiles() {
        file = new File(root);
        File[] listFiles = file.listFiles();
        String[] fileList = new String[listFiles.length];
        for (int i = 0; i < listFiles.length; i++) {
            fileList[i] = listFiles[i].getName();
        }
        return fileList;
    }

    @Override
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void setRoot(String root) {
        this.root = root;
    }

    @Override
    public String getFileName() {
        return fileName;
    }

    public void createAppDirectories(){
        file = new File(root);
        if(!file.exists()){
            file.mkdir();
        }
    }
    
    @Override
    public boolean createNewFile() {
        file = new File(root + fileName);
        if(!file.exists()){
            try {
                return file.createNewFile();
            } catch (IOException ex) {
                System.err.println("Error on creating file: " + ex.getMessage());
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteFile() {
        file = new File(root + fileName);
        return file.delete();
    }

    @Override
    public boolean renameFile(String newName) {
        file = new File(root + fileName);
        File newFile = new File(root + newName);
        file.delete();
        setFileName(newName);
        return file.renameTo(newFile);
    }

    @Override
    public boolean checkExist() {
        file = new File(root + fileName);
        return file.exists();
    }
    
    public boolean checkExist(String filename) {
        file = new File(root + filename);
        return file.exists();
    }
    
}
