package F1.Repositories;

import F1.Entities.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {
    public List<Driver> findAll();
    public Driver findDriverByRaceNumber(int raceNumber);
    public Driver findDriverByUuid(UUID uuid);

    public List<Driver> findDriversByTeamId(UUID teamId);
}
