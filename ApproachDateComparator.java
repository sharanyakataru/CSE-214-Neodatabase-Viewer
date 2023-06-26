import java.util.Comparator;
public class ApproachDateComparator implements Comparator<NearEarthObject>{
    public int compare(NearEarthObject left, NearEarthObject right){
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
