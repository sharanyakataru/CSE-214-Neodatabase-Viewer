/**This is the Neo Viewer class which allows the user to view datasets from the NASA NeoW API
 * @author sharanyakataru
 * email: sharanya.kataru@stonybrook.edu
 * SBU ID: 114850472
 * Recitation: R02
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;

public class NeoViewer {
    public static void main(String[] args) {
        NeoDatabase database;
        database = new NeoDatabase();



        System.out.println("Welcome to NEO Viewer");
        Scanner input = new Scanner(System.in);
        while (true) {
            String userOptions =
                    "    A) Add a page to the database <page>\n" +
                    "    S) Sort the database \n" +
                    "    P) Print the database as a table.\n" +
                    "    Q) Quit";
            System.out.println(userOptions + "\nSelect a menu option: ");
            String letter = input.nextLine();
            letter = letter.toUpperCase();

            switch (letter) {
                case "A":
                    try{
                        System.out.println("Enter the page to load: ");
                        int page = input.nextInt();
                        String value = database.buildQueryURL(page);
                        database.addAll(String.valueOf(value));
                        System.out.println("Page loaded successfully!");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "S":
                    try{
                        List<NearEarthObject> data = new ArrayList<>();
                            System.out.println("  R) Sort by referenceID\n" +
                                    "  D) Sort by diameter\n" +
                                    "  A) Sort by approach date\n" +
                                    "  M) Sort by miss distance\n");

                            System.out.print("Select a menu option:");
                            String option = input.nextLine();
                            option = option.toUpperCase();

                            switch (option){
                                case "R":
                                    database.sort( new ReferenceIDComparator());
                                    System.out.print("Table sorted on reference id.");
                                    break;
                                case "D":
                                    database.sort( new DiameterComparator());
                                    System.out.println("Table sorted on diameter.");
                                    break;
                                case "A":
                                    database.sort( new ApproachDateComparator() );
                                    System.out.println("Table sorted on approach date.");
                                    break;
                                case "M":
                                    database.sort( new MissDistanceComparator());
                                    System.out.println("Table sorted on miss distance.");
                                    break;
                            }

                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "P":
                    try{
                        database.printTable();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "Q":
                    try{
                        System.out.println("Program terminating normally...");
                        System.exit(0);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
            }
        }
    }
}
