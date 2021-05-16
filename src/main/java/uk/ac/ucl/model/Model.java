package uk.ac.ucl.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model
{
    private String filePath;
    private List<String> items;
    private List<String> itemsContents;

    public List<String> getStringItems() {
        if (items == null){
            items = new ArrayList<>();
            items.add("items is null");
        }
        return items;
    }

    // reads a file
    public void readFile(String fileName) throws IOException {
        filePath = fileName;
        File file = new File(filePath);
        String line;
        boolean isLabel = true;
        FileReader freader = new FileReader(file);
        BufferedReader br = new BufferedReader(freader);
        items = new ArrayList<>();
        itemsContents = new ArrayList<>();
        while ((line = br.readLine())!= null)
        {
            if (isLabel){
                items.add(line);
            }
            else{
                itemsContents.add(line);
            }
            isLabel = !isLabel;
        }
        br.close();
        freader.close();
    }

    public String getLabel(int index){
        return items.get(index);
    }

    public String getContent(int index){
        return itemsContents.get(index);
    }

    public int addItem(){
        items.add("");
        itemsContents.add("");
        writeChanges();
        return (items.size()-1);
    }

    public void removeItem(String fileName){
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).compareTo(fileName)== 0){
                items.remove(i);
                itemsContents.remove(i);
            }
        }
        writeChanges();
    }

    public void removeItem(int index){
        for (int i = 0; i < items.size(); i++) {
            if (i == index){
                items.remove(i);
                itemsContents.remove(i);
            }
        }
        writeChanges();
    }

    public List<String> searchFor(String keyword) {
        List<String> results = new ArrayList<>();
        for (String item: items){
            if (item.contains(keyword)){
                results.add(item);
            }
        }
        return results;
    }

    public void setContent(int index, String newLabel, String newContent){
        for (int i = 0; i < items.size(); i ++){
            if (i == index){
                items.set(i, newLabel);
                itemsContents.set(i, newContent);
            }

        }
        writeChanges();
    }

    public void writeChanges(){
        try {
            FileWriter fw = new FileWriter(filePath);
            for(int i = 0; i < items.size(); i ++){
                fw.write(items.get(i));
                fw.write("\n");
                fw.write(itemsContents.get(i));
                fw.write("\n");
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String extractListName(String s){
        return s.substring(0, s.length()-4);
    }

    public void addResults(String keyword, List<String> res, List<String> resLinks){
        for (int i = 0; i < items.size(); i ++){
            String fileName = filePath.substring(5);
            String currentItem = items.get(i);
            if (currentItem.contains(keyword)){
                res.add("\"" + currentItem+"\" from list "+extractListName(fileName));
                resLinks.add("item.html?fileName="+fileName+"&index="+i);
            }
            else {
                currentItem = itemsContents.get(i);
                if (currentItem.contains(keyword)){
                    res.add("\"" + currentItem+"\" from list "+fileName);
                    resLinks.add("item.html?fileName="+fileName +"&index="+i);
                }
            }
        }
    }

    public static void createFile(String fileName) throws IOException {
        FileWriter fw = new FileWriter("data/"+fileName);
        fw.close();
    }

}
