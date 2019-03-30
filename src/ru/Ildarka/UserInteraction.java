package ru.Ildarka;

import javax.swing.*;
import java.util.Map;

class UserInteraction {
    public static String getArchive(String name) {
        JFileChooser fileopen = new JFileChooser();
        int ret = fileopen.showDialog(null, "Choose "+name+" archive");
        if (ret == JFileChooser.APPROVE_OPTION) {
            return fileopen.getSelectedFile().getPath();
        }
        if (ret ==JFileChooser.CANCEL_OPTION){
            System.out.println("programm closes, you clicked cancel");
            System.exit(0);
        }
        System.exit(-1);
        return null;
    }
    public static void showResultOfComparing() {
        InfoAboutArchives infoAboutArchives=InfoAboutArchives.getInfoAboutArchives();
        String format = "|%1$-30s|%2$-30s|\n";
        System.out.format(format,infoAboutArchives.getNameOfOldArch(),infoAboutArchives.getNameOfNewArch());

        for (String string : infoAboutArchives.getDeletedFilesNames()) {
            System.out.format(format, "-" + string, " ");
        }
        for (String string:infoAboutArchives.getNewFilesNames()) {
            System.out.format(format, " ", "+" + string);
        }
        for (String string : infoAboutArchives.getUpdatedFilesNames()) {
            System.out.format(format, "*" + string, "*" + string);
        }
        for (Map.Entry<String,String> renamedNames:infoAboutArchives.getRenamedFilesNames().entrySet()) {
            System.out.format(format, "(?)"+renamedNames.getKey(),"(?)"+renamedNames.getValue());
        }

    }

}

