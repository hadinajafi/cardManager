/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecardmanager2;

import java.util.Properties;

/**
 *
 * @author Hadi Najafi
 */
public interface FileOperations {
    public Properties getData();
    public void setData(Properties data);
    public void writeData();
    public void readData();
    public void setFileName(String fileName);
    public void setRoot(String root);
    public String getFileName();
    public boolean createNewFile();
    public boolean deleteFile();
    public boolean renameFile(String newName);
    public boolean checkExist();
}
