package util;

import entity.Account;
import entity.Asset;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {
// đọc thông tin một account
    public static Account readAccountFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Account) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }
    // đọc một Asset
    public static Asset readAssetFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Asset) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }

    public static ArrayList readDataFromFileVer2(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList)  inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
        }
        return null;
    }
// ghi một mảng
    public static void writeDateToFile(ArrayList<Account> data, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // ghi một đối tượng
    public static void writeDateToFileV2(Object data, String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    public static void writeAccountOnlineToFile(Object data, String fileName) {
//        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
//            outputStream.writeObject(data);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

}
