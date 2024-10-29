package org.victoria2.tools.vic2sgea.gui;

import javafx.scene.chart.PieChart;
import org.victoria2.tools.vic2sgea.entities.Country;
import org.victoria2.tools.vic2sgea.entities.EconomySubject;
import org.victoria2.tools.vic2sgea.entities.Product;
import org.victoria2.tools.vic2sgea.entities.ProductStorage;
import org.victoria2.tools.vic2sgea.main.Report;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountryController extends ChartsController {
    private final Country country;
    private final Map<String, ProductStorage> storageMap;

    private void addUniChart(Function<EconomySubject, Float> getter, String chartName) {
        List<ChartSlice> slices = storageMap.values().stream()
                .filter(productStorage -> getter.apply(productStorage) > 0)
                .map(productStorage -> {
                    String name = productStorage.product.getName();
                    double value = getter.apply(productStorage) * productStorage.getPrice();

                    return new ChartSlice(name, value);
                    //return new ChartSlice(name, value, color);
                })
                .collect(Collectors.toList());

        Consumer<PieChart.Data> onClick = data -> {
            Product foundProduct = report.findProduct(data.getName());
            if (foundProduct != null) {
                Main.showProduct(report, foundProduct);
            }
        };

        Function<PieChart.Data, String> onEnter = data -> {
            ProductStorage productStorage = storageMap.get(data.getName());
            if(productStorage == null) {
                return String.format("%s: %.1f£", data.getName(), data.getPieValue());
            }
            double items = getter.apply(productStorage);
            return String.format("%s: %.1f£ (%.1f 单位)", data.getName(), data.getPieValue(), items);
        };

        String title = String.format("%s - %s (%.1f£)", chartName, country.getOfficialName(), getter.apply(country));
        addChart(slices, title, onEnter, onClick);
    }

    CountryController(final Report report, final Country country) {
        super(report);
        this.country = country;
        this.storageMap = country.getStorage();

        addUniChart(EconomySubject::getGdp, "GDP");
        addUniChart(EconomySubject::getBought, "消费产值");
        addUniChart(EconomySubject::getExported, "出口产值");
        addUniChart(EconomySubject::getImported, "进口产值");
        //addUniChart(report, country, "maxDemand",2,0, "maxDemand");
        addUniChart(EconomySubject::getTotalSupply, "总供应产值");
        addUniChart(EconomySubject::getSold, "实际供应产值");
    }
}

