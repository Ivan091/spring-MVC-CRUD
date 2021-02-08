package price.facrories;

import price.RequesterSCVFile;
import requesters.Requester;

import java.io.*;
import java.util.SortedMap;

public class RequesterSCVFileFactory implements RequesterFactory<SortedMap<Double, Long>> {
    private final InputStream inputStream;

    public RequesterSCVFileFactory(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public Requester<SortedMap<Double, Long>> create() {
        return new RequesterSCVFile(
                new BufferedReader(
                        new InputStreamReader(inputStream)
                )
        );
    }
}
