import java.util.*;
import java.io.*;

public interface IOagenda{
	public void writeToFile(Agenda a,File f) throws IOException;
	public Agenda readFile(File f) throws Exception;
}
