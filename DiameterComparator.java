import java.util.Comparator;
public class DiameterComparator implements Comparator<NearEarthObject> {
    public int compare (NearEarthObject left, NearEarthObject right){
        return Double.compare(left.getAverageDiameter(), right.getAverageDiameter());
    }
}