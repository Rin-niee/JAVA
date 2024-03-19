public class MyClass implements Comparable<MyClass>
{
        int value;
        public MyClass(int value)
        {
            this.value = value;
        }

        @Override
        public int compareTo(MyClass o)
        {
            return Integer.compare(this.value, o.value);
        }

        @Override
        public String toString()
        {
            return String.valueOf(value);
        }
    }
