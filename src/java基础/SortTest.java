package java基础;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortTest {

    public static void main(String[] args) {

        List<FilterTag> filterTagList = new ArrayList<FilterTag>();
        filterTagList.add(new FilterTag("li" + 0, 5));
        filterTagList.add(new FilterTag("li" + 1, 3));
        filterTagList.add(new FilterTag("li" + 2, 20));
        filterTagList.add(new FilterTag("li" + 3, 4));
        filterTagList.add(new FilterTag("li" + 4, 4));
        filterTagList.add(new FilterTag("li" + 5, 1));
        filterTagList.add(new FilterTag("li" + 6, 6));

        Collections.sort(filterTagList, new Comparator<FilterTag>() {
            @Override
            public int compare(FilterTag o1, FilterTag o2) {

                return o1.getOutSortIndex() - o2.getOutSortIndex();
//                return  o2.getOutSortIndex() - o1.getOutSortIndex();
            }
        });

        System.out.println(filterTagList);
    }


    public static class FilterTag {
        private String name;
        private String nameEn;
        private String filterType;
        private String filterKey;
        private String displayMethod;
        private boolean priorityDisplay;
        private int outSortIndex;
        private transient boolean selected;

        public FilterTag(String name, int outSortIndex) {
            this.name = name;
            this.outSortIndex = outSortIndex;
        }

        @Override
        public String toString() {
            return "{"  + name + "="  + outSortIndex +
                    '}';
        }

        public int getOutSortIndex() {
            return outSortIndex;
        }

        public void setOutSortIndex(int outSortIndex) {
            this.outSortIndex = outSortIndex;
        }

        public String getDisplayMethod() {
            return displayMethod;
        }

        public void setDisplayMethod(String displayMethod) {
            this.displayMethod = displayMethod;
        }

        public boolean getSelected() {
            return selected;
        }
        public void setSelected(boolean selected) {
            this.selected = selected;
        }
        public void setName(String name){
            this.name = name;
        }
        public String getName(){
            return this.name;
        }
        public void setNameEn(String nameEn){
            this.nameEn = nameEn;
        }
        public String getNameEn(){
            return this.nameEn;
        }
        public void setFilterType(String filterType){
            this.filterType = filterType;
        }
        public String getFilterType(){
            return this.filterType;
        }
        public void setFilterKey(String filterKey){
            this.filterKey = filterKey;
        }
        public String getFilterKey(){
            return this.filterKey;
        }
        public void setPriorityDisplay(boolean priorityDisplay){
            this.priorityDisplay = priorityDisplay;
        }
        public boolean getPriorityDisplay(){
            return this.priorityDisplay;
        }
    }
}
