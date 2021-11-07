public interface ChristmasTreeDecorator {

    public static ChristmasTree decorateWithBubbleLights(ChristmasTree t) {
        return new ChristmasTree(t.name + " with one BubbleLights");
    }

    public static ChristmasTree decorateWithGarland(ChristmasTree t) {
        return new ChristmasTree(t.name + " with one Garland");
    }
}
