import java.util.Comparator;
public class ReferenceIDComparator implements Comparator<NearEarthObject> {
    public int compare(NearEarthObject left, NearEarthObject right){
        Integer leftID = left.getReferenceID();
        Integer rightID = right.getReferenceID();
        return leftID.compareTo(rightID);
    }

}
