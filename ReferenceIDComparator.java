/**This is the Reference ID Comparator that will sort the Near Earth Objects based on their reference id.
 * @author sharanyakataru
 * email: sharanya.kataru@stonybrook.edu
 * SBU ID: 114850472
 * Recitation: R02
 */
import java.util.Comparator;
public class ReferenceIDComparator implements Comparator<NearEarthObject> {
    public int compare(NearEarthObject left, NearEarthObject right){
        Integer leftID = left.getReferenceID();
        Integer rightID = right.getReferenceID();
        return leftID.compareTo(rightID);
    }

}
