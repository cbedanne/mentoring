import model.Asset;

import java.util.List;
import java.util.function.Predicate;

public class AssetUtil {

    public static int totalAssetsValue(final List<Asset> assets, Predicate<Asset> assetFilter){
        return assets.stream().filter(assetFilter).mapToInt(Asset::getValue).sum();
    }


}
