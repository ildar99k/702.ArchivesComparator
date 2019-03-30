package ru.Ildarka;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static ru.Ildarka.UserInteraction.getArchive;

/*
 *Класс, являющийся контроллером.
 * Выполняет сравнение двух архивов.
 */
class Comparator {

     void compareTwoArchives(String[] archivesPath) {
        InfoAboutArchives infoAboutArchives = InfoAboutArchives.getInfoAboutArchives();
        if (archivesPath.length == 2) {
            infoAboutArchives.setOldArchivePath(archivesPath[0]);
            infoAboutArchives.setNewArchivePath(archivesPath[1]);
        } else {
            infoAboutArchives.setOldArchivePath(getArchive("first"));
            infoAboutArchives.setNewArchivePath(getArchive("second"));
        }

        infoAboutArchives.setOldArchiveFilesAndSizes(getFileInfo(infoAboutArchives.getOldArchivePath()));
        infoAboutArchives.setNewArchiveFilesAndSizes(getFileInfo(infoAboutArchives.getNewArchivePath()));
        infoAboutArchives.fillInfoAboutArchives();
        UserInteraction.showResultOfComparing();
    }

    private HashMap<String, Long> getFileInfo(String archive) {
        if (InfoAboutArchives.getInfoAboutArchives().getNameOfOldArch() != null) {
            InfoAboutArchives.getInfoAboutArchives().setNameOfNewArch(archive.substring(archive.lastIndexOf("\\") + 1, archive.lastIndexOf(".")));
        } else {
            InfoAboutArchives.getInfoAboutArchives().setNameOfOldArch(archive.substring(archive.lastIndexOf("\\") + 1, archive.lastIndexOf(".")));
        }
        if (archive.isEmpty()) {
            System.out.println("you didn't choose archives, programm closes");
            System.exit(-1);
        }
        HashMap<String, Long> archiveFilesAndSizes = new HashMap<>();
        try (FileInputStream fileInputStream = new FileInputStream(archive);
             ZipInputStream zin = new ZipInputStream(fileInputStream)) {
            ZipEntry entry;

            while ((entry = zin.getNextEntry()) != null) {
                archiveFilesAndSizes.put(entry.getName().substring(entry.getName().lastIndexOf("/") + 1), entry.getSize());
                zin.closeEntry();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return archiveFilesAndSizes;
    }

}
