import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AdvancedProjectBase extends ProjectBase{

    public AdvancedProjectBase(List<String> projectTitles) {
        super(projectTitles);
    }

    public Set<String> search(String query){
        Set<String> set = new HashSet<>();
        String[] subQuery;
        if(query.contains(",")){
            subQuery = query.split(",");
            for (int i = 0; i < subQuery.length - 1 ; i++) {
                set.addAll(super.search(subQuery.toString()));
            }
        } else {
            set.addAll(super.search(query));
        }
        return set;
        
    }
    
}
