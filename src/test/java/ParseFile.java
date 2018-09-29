import java.io.*;
import java.util.*;

public class ParseFile {

    public static void main(String[] args) throws FileNotFoundException {
        String filetoparse = "./src/test/java/fileToParse.txt";
        openFile(filetoparse);
    }

    private static void openFile(String Name) throws FileNotFoundException {
        StringBuilder stringbuilder = new StringBuilder();
        File file = new File(Name);
        exists(Name);
        String numbers;
        List<Integer> list = new ArrayList<>();

        try {
            try (BufferedReader bufferedreader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
                while ((numbers = bufferedreader.readLine()) != null) {
                    stringbuilder.append(numbers);
                    Scanner scanner = new Scanner(numbers.replace(",", " "));
                    while (scanner.hasNextInt()) {
                        list.add(scanner.nextInt());
                    }
                    List<Integer> list1 = new ArrayList<>(list);
                    Collections.sort(list);
                    list1.sort(Collections.reverseOrder());
                    System.out.println(""+list);
                    System.out.println(""+list1);
                }
            }
            }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }
}
