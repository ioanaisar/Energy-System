import com.fasterxml.jackson.databind.ObjectMapper;
import input.Input;
import output.Output;
import simulation.Simulations;

import java.io.File;

/**
 * Entry point to the simulation
 */
public final class Main {

    private Main() { }

    /**
     * Main function which reads the input file and starts simulation
     *
     * @param args input and output files
     * @throws Exception might error when reading/writing/opening files, parsing JSON
     */
    public static void main(final String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Input input = mapper.readValue(new File(args[0]), Input.class);
        System.out.print(args[0]);
       Simulations action = new Simulations();
        Output output = action.start(input);

        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(args[1]), output);
    }
}
