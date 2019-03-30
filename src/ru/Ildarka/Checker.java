package ru.Ildarka;

import java.util.*;

class Checker {
    static Map<String, String> checkRename(HashMap<String, Long> oldArchive, HashMap<String, Long> newArchive) {
        Map<String, String> renamedFiles = new HashMap<>();
        for (Map.Entry<String, Long> oldFile : oldArchive.entrySet()) {
            for (Map.Entry<String, Long> newFile : newArchive.entrySet()) {
                if (Objects.equals(oldFile.getValue(), newFile.getValue()) &&!oldFile.getKey().equals(newFile.getKey())) {
                    renamedFiles.put(oldFile.getKey(), newFile.getKey());
                }
            }
        }
        List<String> listOfNames = new ArrayList<>();
        listOfNames.addAll(renamedFiles.keySet());
        listOfNames.addAll(renamedFiles.values());
        Deleter.deleteComparedFiles(oldArchive,newArchive,listOfNames);
        return renamedFiles;
    }

    static List<String> checkUpdate(HashMap<String, Long> oldArchive, HashMap<String, Long> newArchive) {
        List<String> updatedFiles = new ArrayList<>();
        for (Map.Entry<String, Long> oldFile : oldArchive.entrySet()) {
            for (Map.Entry<String, Long> newFile : newArchive.entrySet()) {
                if (oldFile.getKey().equals(newFile.getKey()) && (!Objects.equals(oldFile.getValue(), newFile.getValue()))) {
                    updatedFiles.add(oldFile.getKey());
                }
            }
        }
        Deleter.deleteComparedFiles(oldArchive,newArchive,updatedFiles);
        return updatedFiles;
    }

    static List<String> checkDeletedOrCreated(HashMap<String, Long> firstArchive, HashMap<String, Long> secondArchive) {
        List<String> files = new ArrayList<>();
        boolean maybeDeletedOrUpdated;
        for (Map.Entry<String, Long> fileFromFirstArch : firstArchive.entrySet()) {
            maybeDeletedOrUpdated = true;
            for (Map.Entry<String, Long> fileFromSecondArch : secondArchive.entrySet()) {
                if (fileFromFirstArch.getKey().equals(fileFromSecondArch.getKey())) {
                    maybeDeletedOrUpdated = false;
                    break;
                }
            }
            if (maybeDeletedOrUpdated) {
                files.add(fileFromFirstArch.getKey());
            }
        }
        Deleter.deleteComparedFiles(firstArchive,secondArchive,files);
        return files;
    }

}
