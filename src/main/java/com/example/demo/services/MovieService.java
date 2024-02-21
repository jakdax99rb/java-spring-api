package com.example.demo.services;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.demo.domain.MovieRecord;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

import graphql.com.google.common.base.Optional;
import lombok.Getter;

@Component
public class MovieService {

    @Value("${csvPath}")
    private String csvPath;
    @Getter
    private List<MovieRecord> listOfMovieRecords;

    public MovieService() {
        this.listOfMovieRecords = populateListOfMovieRecords();
    }

    private List<MovieRecord> populateListOfMovieRecords() {
        Optional<List<String[]>> loadedDataOptional = loadCSV();

        if (!loadedDataOptional.isPresent()) {
            return new ArrayList<MovieRecord>();
        }

        List<String[]> loadedData = loadedDataOptional.get();
        ArrayList<MovieRecord> movieRecordList = new ArrayList<MovieRecord>();

        loadedData.forEach((movieStrings) -> {
            movieRecordList.add(new MovieRecord(movieStrings));
        });

        return movieRecordList;
    }

    private Optional<List<String[]>> loadCSV() {
        try {
            FileReader fileReader = new FileReader(csvPath);
            CSVReader csvReader = new CSVReaderBuilder(fileReader).withSkipLines(1).build();

            List<String[]> allData = csvReader.readAll();
            fileReader.close();
            return Optional.of(allData);
        } catch (Exception e) {
            e.printStackTrace();
            return Optional.absent();
        }
    }

}
 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    