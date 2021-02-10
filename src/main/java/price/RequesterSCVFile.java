package price;

import exceptions.*;
import requesters.Requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.*;

public class RequesterSCVFile implements Requester<SortedMap<Double, Long>> {

    private final BufferedReader reader;

    public RequesterSCVFile(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public SortedMap<Double, Long> request() throws RequestFailureException, RequestInterruptedException {

        var map = new TreeMap<Double, Long>();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                var values = line.split(",");
                map.put(Double.parseDouble(values[0]), Long.parseLong(values[1]));
            }
        } catch (IOException io) {
            throw new RequesterCreationException(io.getMessage() + Arrays.toString(io.getStackTrace()));
        }
        return map;
    }
}
