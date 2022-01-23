public interface IStockFeed
{
int GetSharePrice(string company);
}
public class StockAnalyzer
{
private IStockFeed stockFeed;
public StockAnalyzer(IStockFeed feed)
{
stockFeed = feed;
}
public int GetContosoPrice()
{
return stockFeed.GetSharePrice("COOO");
}
}

Public Interface IStockFeed
Function GetSharePrice(company As String) As Integer
End Interface
Public Class StockAnalyzer
' StockAnalyzer can be connected to any IStockFeed:
Private stockFeed As IStockFeed
Public Sub New(feed As IStockFeed)
stockFeed = feed
End Sub
Public Function GetContosoPrice()
Return stockFeed.GetSharePrice("COOO")
End Function
End Class