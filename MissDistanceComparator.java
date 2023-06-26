import java.util.Comparator;
public class MissDistanceComparator implements Comparator<NearEarthObject> {
    public int compare(NearEarthObject left, NearEarthObject right){
        return Double.compare(left.getMissDistance(), right.getMissDistance());
    }
}
