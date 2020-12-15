package shared;

import java.util.UUID;
import Service;

@Service
public class Utils {
    public String generateUserId()
    {
        return UUID.randomUUID().toString();
    }
}