package bangbanggokgok.com.com.com.mobile_project;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by User on 2018-06-07.
 */

public class InfoList extends Fragment {
    Document doc = null;
    TextView textview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.infolist,container,false);
        textview = view.findViewById(R.id.InfoList);
        new GetXMLTask().execute("http://www.culture.go.kr/openapi/rest/publicperformancedisplays/realm?ServiceKey=" +
                "qRzDzTz85rxbcjeZoCMhi739iMERvTiZzZcQhaREYzRN6IZhuv1Kv63NJYgkVEHBXxOa%2FSk%2FgeOPl%2FE4rujMFQ%3D%3D");
        return view;
    }
    private class GetXMLTask extends AsyncTask<String, Void, Document>{

        @Override
        protected Document doInBackground(String... urls) {
            URL url;
            try {
                url = new URL(urls[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder(); //XML문서 빌더 객체를 생성
                doc = db.parse(new InputSource(url.openStream())); //XML문서를 파싱한다.
                doc.getDocumentElement().normalize();

            } catch (Exception e) {
                //Toast.makeText(getBaseContext(), "Parsing Error", Toast.LENGTH_SHORT).show();
            }
            return doc;
        }

        @Override
        protected void onPostExecute(Document doc) {

            String s = "";
            //data태그가 있는 노드를 찾아서 리스트 형태로 만들어서 반환

            NodeList nodeList = doc.getElementsByTagName("perforList");
            //data 태그를 가지는 노드를 찾음, 계층적인 노드 구조를 반환
            if (nodeList != null) {
                for (int i = 0; i < nodeList.getLength(); i++) {

                    //날씨 데이터를 추출
                    s += "" + i + " : ";
                    Node node = nodeList.item(i); //data엘리먼트 노드
                    Element fstElmnt = (Element) node;
                    NodeList nameList = fstElmnt.getElementsByTagName("seq");
                    Element nameElement = (Element) nameList.item(0);
                    nameList = nameElement.getChildNodes();
                    s += "seq = " + ((Node) nameList.item(0)).getNodeValue() + "\n";


                }

                textview.setText(s);

                super.onPostExecute(doc);
            }else{
                textview.setText("null");
            }
            super.onPostExecute(doc);
        }




    }//end inner class - GetXMLTask
}


