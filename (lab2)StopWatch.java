public class StopWatch
{
    private long startTime;
    private long endTime;

    public StopWatch()
    {
        reset();
    }

    public void reset()
    {
        startTime = System.currentTimeMillis();
    }

    public void start()
    {
        reset();
    }

    public void stop() {
        endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

}
