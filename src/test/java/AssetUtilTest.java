import model.Asset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AssetUtilTest {

    @Test
    void totalAssetsValue() {

        assertThat(AssetUtil.totalAssetsValue(Asset.someAssets(),asset->asset.getType()== Asset.AssetType.BOND)).isEqualTo(3000);
        assertThat(AssetUtil.totalAssetsValue(Asset.someAssets(),asset->asset.getType()== Asset.AssetType.STOCK)).isEqualTo(7000);
        assertThat(AssetUtil.totalAssetsValue(Asset.someAssets(),asset-> Boolean.TRUE)).isEqualTo(10000);

    }
}