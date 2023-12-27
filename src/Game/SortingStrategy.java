package Game;

import Board.Property;
import java.util.List;
import java.util.stream.Collectors;

public interface SortingStrategy {
    void sort(List<Property> properties);

    public class UtilitySortingStrategy implements SortingStrategy {
        @Override
        public void sort(List<Property> properties) {
            List<Property> utilities = properties.stream()
                    .filter(p -> p.getPropertyType() == Property.Type.UTILITY)
                    .sorted()
                    .collect(Collectors.toList());

            properties.clear();
            properties.addAll(utilities);
        }
    }

    public class RailroadSortingStrategy implements SortingStrategy {
        @Override
        public void sort(List<Property> properties) {
            List<Property> railroads = properties.stream()
                    .filter(p -> p.getPropertyType() == Property.Type.RAILROAD)
                    .sorted()
                    .collect(Collectors.toList());

            properties.clear();
            properties.addAll(railroads);
        }
    }

    public class StandardPropertySortingStrategy implements SortingStrategy {
        @Override
        public void sort(List<Property> properties) {
            List<Property> standardProperties = properties.stream()
                    .filter(p -> p.getPropertyType() == Property.Type.STANDARD)
                    .sorted()
                    .collect(Collectors.toList());

            properties.clear();
            properties.addAll(standardProperties);
        }
    }
}
