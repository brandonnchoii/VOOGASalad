package engine.gameobject.units;

/**
 * Generally, how a buff should works is initialApply -> advanceTime (until the end of duration) -> unbuff. For example,
 * a burning unbuff will (not do anything) -> (take away health every (advanceTime) time) -> (not do anything)
 * @author Danny
 *
 */
public abstract class Buff {
    private int duration;
    private int timeSinceStart;

    public Buff(int duration){
        this.duration=duration;
        timeSinceStart = 0;
    }

    public abstract void apply (BuffableUnit myUnit);

    public abstract void unapply (BuffableUnit myUnit);

    public void advanceTime (int timePassed, BuffableUnit myUnit) {
        timeSinceStart = timeSinceStart + timePassed;
        changeOverTime();
    }

    protected void changeOverTime(){
        
    }
    
    public int timeLeft () {
        return duration - timeSinceStart;
    }

    public abstract boolean isStrongerBuff(Buff otherBuff);
}