package me.codebase.utilFramework.univocity;

import com.univocity.parsers.common.processor.BeanWriterProcessor;
import com.univocity.parsers.csv.CsvWriter;
import com.univocity.parsers.csv.CsvWriterSettings;
import me.codebase.utilFramework.univocity.rsp.FlowerGirl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CsvExportDemo {

    public static void main(String[] args) throws FileNotFoundException {

        Random luckyAss = new Random(System.currentTimeMillis());

        List<FlowerGirl> flowers = IntStream.range(0, 10).mapToObj(i -> buildOne(luckyAss)).collect(Collectors.toList());
        FileOutputStream stream = new FileOutputStream(new File("Gift.csv"));
        CsvWriterSettings settings = new CsvWriterSettings();
        settings.setRowWriterProcessor(new BeanWriterProcessor<>(FlowerGirl.class));
        CsvWriter writer = new CsvWriter(stream, Charset.forName("UTF-8"), settings);
        writer.writeHeaders();
        flowers.forEach(writer::processRecord);
        writer.close();
    }

    private static FlowerGirl buildOne(Random luckyAss) {
        FlowerGirl flower = new FlowerGirl();
        flower.setAge(luckyAss.nextInt());
        flower.setPlaceOfProduction("Earth");
        flower.setName("Unknow");
        flower.setGender("Not sure");
        return flower;
    }

}
