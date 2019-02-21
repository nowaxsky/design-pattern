# Singleton Pattern 獨體模式

## 問題

1. 建立一個類別把所有的方法和變數都定義為靜態, 直接把這個類別當作一個獨體, 為何還需要獨體模式?
	* 前者確實可以只建造一個獨體, 但靜態初始化的控制權是JVM, 如果有許多類別牽涉在其中時, 有可能因為JVM控制初始化的次序而導致預期外的錯誤. 
	* __建議: 除非有絕對的必要使用類別的獨體(即類別內均為靜態方法和靜態變數), 否則還是使用物件的獨體比較保險.__
1. 如果有2個Class loader(類別載入器), 會不會導致創造各自的獨體?
	* 確實有可能, 如果有2個Class loader, 且classPath不為ExtClassLoader或AppClassLoader的搜尋路徑, 如此同一個類別會分別由2個Class loader載入, 結果確實會產生2個實例.
	* 解決方法: 要自行指定Class loader, 並指定同一個Class loader.
	* Class loader說明: https://openhome.cc/Gossip/JavaEssence/ClassLoader.html.
	* 多個Class loader載入:
	https://openhome.cc/Gossip/JavaEssence/MyClassLoader.html.
1. 能不能繼承獨體類別?
	* 如果要繼承獨體類別, 就必須把建構式公開, 但如此就不是真正的獨體了. 且另外一個問題是, 獨體的實踐是使用靜態變數, 直接繼承將導致所有衍生類別共用這個實體變數, 這可能並不好用.
	* 這個問題應該想成, 有什麼樣的情境需要繼承獨體類別? 這種情境應該不多, 就算真的有, 獨體的實踐也非常容易, 如果真的需要繼承可以考慮使用Registry of Singleton(獨體登錄).
	* 獨立類別繼承問題: http://www.blogjava.net/jesson2005/archive/2012/03/19/111167.html.
	* Registry of Singleton: https://openhome.cc/Gossip/DesignPattern/RegistryOfSingleton.htm.
1. 為何全域變數比獨體模式差?
	* 在Java中全域變數基本上就是靜態變數, 一個主要的缺點就是 __率先實體化比拖延實體化更浪費資源__ .
	* __獨體模式是確保類別只有一個實體, 並提供全域存取的方式; 全域變數僅能提供全域存取, 不能確保只有一個實體.__
	* 使用全域變數也變相鼓勵開發者用許多全域變數指向小物件, 造成namespace(名稱空間)的汙染. 
