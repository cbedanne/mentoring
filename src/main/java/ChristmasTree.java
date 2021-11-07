import java.awt.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class ChristmasTree {

    String name;
    private Function<ChristmasTree,ChristmasTree> decorator;

    public ChristmasTree(String name) {
        this.name=name;
    }

    public void setDecorator(final Function<ChristmasTree,ChristmasTree>... ctDecorator){
        decorator=Stream.of(ctDecorator)
                .reduce((dec,next)->dec.compose(next))
                .orElse(ct -> ct);
    }

    public ChristmasTree decorate(ChristmasTree tree) {
       final ChristmasTree decoratedChristmasTree=decorator.apply(tree);
        return decoratedChristmasTree;
    }

    public static void main(final String[] args) {
        final ChristmasTree christmasTree = new ChristmasTree("My ChristmasTree");
        final Consumer<String> printDecorator = (decoratorInfo) ->
                System.out.println(String.format(" %s: %s", decoratorInfo,
                        christmasTree.decorate(new ChristmasTree("Empty tree")).name));


        christmasTree.setDecorator(ChristmasTreeDecorator::decorateWithBubbleLights);
        printDecorator.accept("With Bubble Ligths");
        christmasTree.setDecorator(ChristmasTreeDecorator::decorateWithBubbleLights,ChristmasTreeDecorator::decorateWithGarland,ChristmasTreeDecorator::decorateWithGarland);
        printDecorator.accept("With Bubble Ligths");


    }


}
