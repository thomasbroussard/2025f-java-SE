package fr.epita.biostat.services;

import fr.epita.biostat.datamodel.BioStatEntry;

import java.util.List;
import java.util.function.Function;

public class StatService {




    public static double computeAverage(List<BioStatEntry> entries, Function<BioStatEntry, Integer> f) {
        double total = 0;
        for(BioStatEntry entry : entries){
            total += f.apply(entry);
        }
        return total / entries.size();
    }

}
