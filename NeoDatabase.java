import java.text.SimpleDateFormat;
import java.util.*;
import big.data.DataSource;
import java.text.DateFormat;
public class NeoDatabase {
    public static final String API_KEY = "GqhhBRdAP3VevOzaohOzsQoAfdy60VxJQIcJMzWz";
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";
    private List<NearEarthObject> database;
    public NeoDatabase(){
        this.database = new ArrayList<>();
    }

    /**This method builds a query URL
     * @param pageNumber
     * integers from 0 to 715 that indicated the page the user wants to load
     * @return
     * builds a query URL based on the page number
     * @throws IllegalArgumentException
     * if the page number is not valid
     */
    public String buildQueryURL(int pageNumber) throws IllegalArgumentException{
        if(pageNumber < 0 || pageNumber > 715){
            throw new IllegalArgumentException("Page number is not in the valid range.");
        }

        return API_ROOT + "page="+ pageNumber + "&api_key=" + API_KEY;
    }

    /** This method opens a connection to the data source indicated by queryURL
     * @param queryURL
     * string that has the URL requesting a dataset from the NASA service
     * @throws IllegalArgumentException
     * if query is null or could not be found by the server
     */
    public void addAll(String queryURL) throws IllegalArgumentException{
        if(queryURL == null){
            throw new IllegalArgumentException("Query URL cannot be null.");
        }
        List<NearEarthObject> objects = database;
        if (objects == null){
            throw new IllegalArgumentException("Query URL cannot be resolved by the server");
        }
        DataSource ds = DataSource.connectJSON(queryURL);
        ds.load();

        // Constructs and returns an array of 3 MyData instances.
        // fetchArray() takes the name of the class as a String as the first parameter, then a
        // list of identifiers showing it where to find the values for the constructor parameters.
        NearEarthObject[] myDatas = ds.fetchArray(
                "NearEarthObject",                    // Name of the class as a String.
                "near_earth_objects/neo_reference_id",    // Identifier for constructor parameter 1 (initString).
                "near_earth_objects/name",    // Identifier for constructor parameter 2 (initDouble).
                "near_earth_objects/absolute_magnitude_h",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min",
                "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max",
                "near_earth_objects/is_potentially_hazardous_asteroid",
                "near_earth_objects/close_approach_data/epoch_date_close_approach",
                "near_earth_objects/close_approach_data/miss_distance/kilometers",
                "near_earth_objects/close_approach_data/orbiting_body"
        );

        for(int i = 0; i < myDatas.length; ++i) {
//            System.out.println(myDatas[i].toString());
            database.add(myDatas[i]);
        }


    }

    /**This method sorts the database using the specified comparators
     * @param comp
     * comparator of NearEarthObjects that will be used to sort the database
     * @throws IllegalArgumentException
     * if comp is null
     */
    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{
        if(comp == null){
            throw new IllegalArgumentException("Comparator cannot be null");
        }
        List<NearEarthObject> sortData = new ArrayList<>(database);
        Collections.sort(sortData, comp);
        database.clear();
        database.addAll(sortData);

    }

    /**This method prints the database
     */
    public void printTable(){
        System.out.println("ID   |           Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits" +
                "\n================================================================================================");
        for(NearEarthObject object : this.database){
            DateFormat date = new SimpleDateFormat("MM-dd-yyyy");
            String myDate = date.format(object.getClosestApproachDate());
            double x = Math.round(object.getAbsoluteMagnitude() * 10) / 10.0;


            System.out.printf("%-10s%-29s%-9s%-11s%-10s%-14s%-13s%-4s\n",object.getReferenceID(), object.getName(), x,
                    object.getAverageDiameter(), object.getIsDangerous(), myDate, object.getMissDistance(), object.getOrbitingBody());
        }

    }

}
