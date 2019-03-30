package ru.Ildarka;

import java.util.HashMap;
import java.util.List;

/*
 *Удаляет ненужные пары в мапах
 */
class Deleter {
    static void deleteComparedFiles(HashMap<String, Long> oldArchive, HashMap<String, Long> newArchive, List<String> names) {
        for (String name : names) {
            oldArchive.remove(name);
            newArchive.remove(name);
        }
    }
}
