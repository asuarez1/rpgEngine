package engine.combat;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Party {
    public List<Entity> partyMembers = new ArrayList<>();

    public List<Entity> getAliveEntities() {
        return partyMembers.stream().filter(e -> !e.getEntityStats().isDead()).collect(Collectors.toList());
    }
}
