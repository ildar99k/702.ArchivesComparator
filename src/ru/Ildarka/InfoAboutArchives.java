package ru.Ildarka;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static InfoAboutArchives getInfoAboutArchives() {
        return infoAboutArchives;
    }

    public Map<String, String> getRenamedFilesNames() {
        return renamedFilesNames;
    }

    private void setRenamedFilesNames(Map<String, String> renamedFilesNames) {
        this.renamedFilesNames = renamedFilesNames;
    }

    public List<String> getDeletedFilesNames() {
        return deletedFilesNames;
    }

    private void setDeletedFilesNames(List<String> deletedFilesNames) {
        this.deletedFilesNames = deletedFilesNames;
    }

    public List<String> getUpdatedFilesNames() {
        return updatedFilesNames;
    }

    private void setUpdatedFilesNames(List<String> updatedFilesNames) {
        this.updatedFilesNames = updatedFilesNames;
    }

    public List<String> getNewFilesNames() {
        return newFilesNames;
    }

    private void setNewFilesNames(List<String> newFilesNames) {
        this.newFilesNames = newFilesNames;
    }

    private HashMap<String, Long> getOldArchiveFilesAndSizes() {
        return oldArchiveFilesAndSizes;
    }

    public void setOldArchiveFilesAndSizes(HashMap<String, Long> oldArchiveFilesAndSizes) {
        this.oldArchiveFilesAndSizes = oldArchiveFilesAndSizes;
    }

    private HashMap<String, Long> getNewArchiveFilesAndSizes() {
        return newArchiveFilesAndSizes;
    }

    public String getOldArchivePath() {
        return oldArchivePath;
    }

    public void setOldArchivePath(String oldArchivePath) {
        this.oldArchivePath = oldArchivePath;
    }

    public String getNewArchivePath() {
        return newArchivePath;
    }

    public void setNewArchivePath(String newArchivePath) {
        this.newArchivePath = newArchivePath;
    }

    public String getNameOfOldArch() {
        return nameOfOldArch;
    }

    public void setNameOfOldArch(String nameOfOldArch) {
        this.nameOfOldArch = nameOfOldArch;
    }

    public String getNameOfNewArch() {
        return nameOfNewArch;
    }

    public void setNameOfNewArch(String nameOfNewArch) {
        this.nameOfNewArch = nameOfNewArch;
    }

    public void setNewArchiveFilesAndSizes(HashMap<String, Long> newArchiveFilesAndSizes) {
        this.newArchiveFilesAndSizes = newArchiveFilesAndSizes;
    }

    public void fillInfoAboutArchives() {
        setUpdatedFilesNames(Checker.checkUpdate(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
        setRenamedFilesNames(Checker.checkRename(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
        setNewFilesNames(Checker.checkDeletedOrCreated(getNewArchiveFilesAndSizes(), getOldArchiveFilesAndSizes()));
        setDeletedFilesNames(Checker.checkDeletedOrCreated(getOldArchiveFilesAndSizes(), getNewArchiveFilesAndSizes()));
    }
}
