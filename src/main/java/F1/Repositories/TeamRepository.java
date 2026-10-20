package F1.Repositories;

import F1.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeamRepository extends JpaRepository<Team, UUID>{
    public List<Team> findAll();
    public Team getTeamByName(String name);
}
