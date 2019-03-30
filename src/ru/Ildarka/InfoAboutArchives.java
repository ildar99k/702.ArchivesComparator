package ru.Ildarka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Класс, содержащий всю информацию о двух архивах, является хранилищем(Синглтон)
 */
class InfoAboutArchives {
    private static final InfoAboutArchives infoAboutArchives = new InfoAboutArchives();
    private String nameOfOldArch;
    private String nameOfNewArch;
    private String oldArchivePath;
    private String newArchivePath;
    private Map<String, String> renamedFilesNames;
    private List<String> deletedFilesNames;
    private List<String> updatedFilesNames;
    private List<String> newFilesNames;
    private HashMap<String, Long> oldArchiveFilesAndSizes;
    private HashMap<String, Long> newArchiveFilesAndSizes;

    private InfoAboutArchives() {
    }

    static InfoAboutArchives getInfoAboutArchives() {
        return infoAboutArchives;
    }

    Map<String, String> getRenamedFilesNames() {
        return renamedFilesNames;
    }

    private void setRenamedFilesNames(Map<String, String> renamedFilesNames) {
        this.renamedFilesNames = renamedFilesNames;
    }

    List<String> getDeletedFilesNames() {
        return deletedFilesNames;
    }

    private void setDeletedFilesNames(List<String> deletedFilesNames) {
        this.deletedFilesNames = deletedFilesNames;
    }

    List<String> getUpdatedFilesNames() {
        return updatedFilesNames;
    }

    private void setUpdatedFilesNames(List<String> updatedFilesNames) {
        this.updatedFilesNames = updatedFilesNames;
    }

    List<String> getNewFilesNames() {
        return newFilesNames;
    }

    private void setNewFilesNames(List<String> newFilesNames) {
        this.newFilesNames = newFilesNames;
    }

    private HashMap<String, Long> getOldArchiveFilesAndSizes() {
        return oldArchiveFilesAndSizes;
    }

    void setOldArchiveFilesAndSizes(HashMap<String, Long> oldArchiveFilesAndSizes) {
        this.oldArchiveFilesAndSizes = oldArchiveFilesAndSizes;
    }

    private HashMap<String, Long> getNewArchiveFilesAndSizes() {
        return newArchiveFilesAndSizes;
    }

    String getOldArchivePath() {
        return oldArchivePath;
    }

    void setOldArchivePath(String oldArchivePath) {
        this.oldArchivePath = oldArchivePath;
    }

    String getNewArchivePath() {
        return newArchivePath;
    }

    void setNewArchivePath(String newArchivePath) {
        this.newArchivePath = newArchivePath;
    }

    String getNameOfOldArch() {
        return nameOfOldArch;
    }

     void setNameOfOldArch(String nameOfOldArch) {
        this.nameOfOldArch = nameOfOldArch;
    }

    String getNameOfNewArch() {
        return nameOfNewArch;
    }

    void setNameOfNewArch(String nameOfNewArch) {
        this.nameOfNewArch = nameOfNewArch;
    }

    void setNewArchiveFilesAndSizes(HashMap<String, Long> newArchiveFilesAndSizes) {
        this.newArchiveFilesAndSizes = newArchiveFilesAndSizes;
    }

    void fillInfoAboutArchives() {
        setUpdatedFilesNames(Checker.checkUpdate(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
        setRenamedFilesNames(Checker.checkRename(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
        setNewFilesNames(Checker.checkDeletedOrCreated(getNewArchiveFilesAndSizes(), getOldArchiveFilesAndSizes()));
        setDeletedFilesNames(Checker.checkDeletedOrCreated(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
    }
}
