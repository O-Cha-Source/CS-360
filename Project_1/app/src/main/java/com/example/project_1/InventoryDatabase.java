package com.example.project_1;

import android.content.Context;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class InventoryDatabase {
    public static final String FILENAME = "inventory.txt";

    private Context mContext;
    private List<Item> mItemList;

    public InventoryDatabase(Context context){
        mContext = context;
        mItemList = new ArrayList<>();
    }

    public void addItem(Item item) throws IllegalArgumentException{
        mItemList.add(item);
    }

    public Item[] getItems(){
        Item[] items = new Item[mItemList.size()];
        return items;
    }

    public void clear(){
        mItemList.clear();
    }

    public void saveToFile() throws IOException{
        FileOutputStream outputStream = mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE);
        writeListToStream(outputStream);
    }

    public void readFromFile() throws IOException{
        BufferedReader reader = null;

        try{
            FileInputStream inputStream = mContext.openFileInput(FILENAME);
            reader = new BufferedReader(new InputStreamReader(inputStream));

            mItemList.clear();

            Item readItem = new Item();
            String tempLine;
            while((tempLine = reader.readLine()) != null){
                readItem.setName(tempLine);
                readItem.setDescription(reader.readLine());
                mItemList.add(readItem);
            }
        }
        catch (FileNotFoundException ex){
            //ignored for now
        }
        finally{
            if (reader != null){
                reader.close();
            }
        }
    }

    private void writeListToStream(FileOutputStream outputStream){
        PrintWriter writer = new PrintWriter(outputStream);
        for(Item item : mItemList){
            writer.println(item.getName());
            writer.println(item.getDescription());
        }
        writer.close();
    }



}
