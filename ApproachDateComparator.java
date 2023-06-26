/**This is the Comparator class that sorts the Near Earth Objects based on their Approach Date.
 * @author sharanyakataru
 * email: sharanya.kataru@stonybrook.edu
 * SBU ID: 114850472
 * Recitation: R02
 */
import java.util.Comparator;
public class ApproachDateComparator implements Comparator<NearEarthObject>{
    public int compare(NearEarthObject left, NearEarthObject right){
        return left.getClosestApproachDate().compareTo(right.getClosestApproachDate());
    }
}
