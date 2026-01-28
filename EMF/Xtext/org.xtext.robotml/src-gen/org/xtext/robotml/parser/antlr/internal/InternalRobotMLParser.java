package org.xtext.robotml.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.robotml.services.RobotMLGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalRobotMLParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Assignation'", "'{'", "'variableDecl'", "'expression'", "'}'", "'VariableDeclaration'", "'type'", "'String'", "'Boolean'", "'Integer'", "'Float'", "'Void'", "'FunctionCall'", "'functiondeclaration'", "'parameters'", "'('", "','", "')'", "'expresion'", "'Binary'", "'Operator'", "'operands'", "'Unary'", "'operand'", "'VariableRef'", "'ref'", "'GetSpeed'", "'GetClock'", "'GetSensor'", "'sensor'", "'FunctionDeclaration'", "'returnType'", "'block'", "'Block'", "'statements'", "'Condition'", "'conditions'", "'setSpeed'", "'SetClock'", "'Rotate'", "'Forward'", "'Backward'", "'Leftward'", "'Rightward'", "'AND'", "'OR'", "'NOT'", "'EQUAL'", "'LESSOREQUAL'", "'GREATEROREQUAL'", "'LESS'", "'GREATER'", "'PLUS'", "'MINUS'", "'TIMES'", "'DIVIDE'", "'MODULO'", "'NOTEQUAL'", "'NEGATE'", "'Distance'", "'Color'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalRobotMLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalRobotMLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalRobotMLParser.tokenNames; }
    public String getGrammarFileName() { return "InternalRobotML.g"; }



     	private RobotMLGrammarAccess grammarAccess;

        public InternalRobotMLParser(TokenStream input, RobotMLGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Assignation";
       	}

       	@Override
       	protected RobotMLGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleAssignation"
    // InternalRobotML.g:65:1: entryRuleAssignation returns [EObject current=null] : iv_ruleAssignation= ruleAssignation EOF ;
    public final EObject entryRuleAssignation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignation = null;


        try {
            // InternalRobotML.g:65:52: (iv_ruleAssignation= ruleAssignation EOF )
            // InternalRobotML.g:66:2: iv_ruleAssignation= ruleAssignation EOF
            {
             newCompositeNode(grammarAccess.getAssignationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAssignation=ruleAssignation();

            state._fsp--;

             current =iv_ruleAssignation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignation"


    // $ANTLR start "ruleAssignation"
    // InternalRobotML.g:72:1: ruleAssignation returns [EObject current=null] : (otherlv_0= 'Assignation' otherlv_1= '{' otherlv_2= 'variableDecl' ( (lv_variableDecl_3_0= ruleVariableDeclaration ) ) otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' ) ;
    public final EObject ruleAssignation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_variableDecl_3_0 = null;

        EObject lv_expression_5_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:78:2: ( (otherlv_0= 'Assignation' otherlv_1= '{' otherlv_2= 'variableDecl' ( (lv_variableDecl_3_0= ruleVariableDeclaration ) ) otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' ) )
            // InternalRobotML.g:79:2: (otherlv_0= 'Assignation' otherlv_1= '{' otherlv_2= 'variableDecl' ( (lv_variableDecl_3_0= ruleVariableDeclaration ) ) otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )
            {
            // InternalRobotML.g:79:2: (otherlv_0= 'Assignation' otherlv_1= '{' otherlv_2= 'variableDecl' ( (lv_variableDecl_3_0= ruleVariableDeclaration ) ) otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}' )
            // InternalRobotML.g:80:3: otherlv_0= 'Assignation' otherlv_1= '{' otherlv_2= 'variableDecl' ( (lv_variableDecl_3_0= ruleVariableDeclaration ) ) otherlv_4= 'expression' ( (lv_expression_5_0= ruleExpression ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getAssignationAccess().getAssignationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getAssignationAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getAssignationAccess().getVariableDeclKeyword_2());
            		
            // InternalRobotML.g:92:3: ( (lv_variableDecl_3_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:93:4: (lv_variableDecl_3_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:93:4: (lv_variableDecl_3_0= ruleVariableDeclaration )
            // InternalRobotML.g:94:5: lv_variableDecl_3_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getAssignationAccess().getVariableDeclVariableDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_6);
            lv_variableDecl_3_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignationRule());
            					}
            					set(
            						current,
            						"variableDecl",
            						lv_variableDecl_3_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getAssignationAccess().getExpressionKeyword_4());
            		
            // InternalRobotML.g:115:3: ( (lv_expression_5_0= ruleExpression ) )
            // InternalRobotML.g:116:4: (lv_expression_5_0= ruleExpression )
            {
            // InternalRobotML.g:116:4: (lv_expression_5_0= ruleExpression )
            // InternalRobotML.g:117:5: lv_expression_5_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getAssignationAccess().getExpressionExpressionParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_5_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAssignationRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_5_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getAssignationAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignation"


    // $ANTLR start "entryRuleExpression"
    // InternalRobotML.g:142:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalRobotML.g:142:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalRobotML.g:143:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalRobotML.g:149:1: ruleExpression returns [EObject current=null] : (this_FunctionCall_0= ruleFunctionCall | this_Binary_1= ruleBinary | this_Unary_2= ruleUnary | this_VariableRef_3= ruleVariableRef | this_GetSpeed_4= ruleGetSpeed | this_GetClock_5= ruleGetClock | this_GetSensor_6= ruleGetSensor ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionCall_0 = null;

        EObject this_Binary_1 = null;

        EObject this_Unary_2 = null;

        EObject this_VariableRef_3 = null;

        EObject this_GetSpeed_4 = null;

        EObject this_GetClock_5 = null;

        EObject this_GetSensor_6 = null;



        	enterRule();

        try {
            // InternalRobotML.g:155:2: ( (this_FunctionCall_0= ruleFunctionCall | this_Binary_1= ruleBinary | this_Unary_2= ruleUnary | this_VariableRef_3= ruleVariableRef | this_GetSpeed_4= ruleGetSpeed | this_GetClock_5= ruleGetClock | this_GetSensor_6= ruleGetSensor ) )
            // InternalRobotML.g:156:2: (this_FunctionCall_0= ruleFunctionCall | this_Binary_1= ruleBinary | this_Unary_2= ruleUnary | this_VariableRef_3= ruleVariableRef | this_GetSpeed_4= ruleGetSpeed | this_GetClock_5= ruleGetClock | this_GetSensor_6= ruleGetSensor )
            {
            // InternalRobotML.g:156:2: (this_FunctionCall_0= ruleFunctionCall | this_Binary_1= ruleBinary | this_Unary_2= ruleUnary | this_VariableRef_3= ruleVariableRef | this_GetSpeed_4= ruleGetSpeed | this_GetClock_5= ruleGetClock | this_GetSensor_6= ruleGetSensor )
            int alt1=7;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt1=1;
                }
                break;
            case 30:
                {
                alt1=2;
                }
                break;
            case 33:
                {
                alt1=3;
                }
                break;
            case 35:
                {
                alt1=4;
                }
                break;
            case 37:
                {
                alt1=5;
                }
                break;
            case 38:
                {
                alt1=6;
                }
                break;
            case 39:
                {
                alt1=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalRobotML.g:157:3: this_FunctionCall_0= ruleFunctionCall
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getFunctionCallParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_0=ruleFunctionCall();

                    state._fsp--;


                    			current = this_FunctionCall_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRobotML.g:166:3: this_Binary_1= ruleBinary
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getBinaryParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Binary_1=ruleBinary();

                    state._fsp--;


                    			current = this_Binary_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRobotML.g:175:3: this_Unary_2= ruleUnary
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getUnaryParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Unary_2=ruleUnary();

                    state._fsp--;


                    			current = this_Unary_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRobotML.g:184:3: this_VariableRef_3= ruleVariableRef
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getVariableRefParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableRef_3=ruleVariableRef();

                    state._fsp--;


                    			current = this_VariableRef_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRobotML.g:193:3: this_GetSpeed_4= ruleGetSpeed
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getGetSpeedParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetSpeed_4=ruleGetSpeed();

                    state._fsp--;


                    			current = this_GetSpeed_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRobotML.g:202:3: this_GetClock_5= ruleGetClock
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getGetClockParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetClock_5=ruleGetClock();

                    state._fsp--;


                    			current = this_GetClock_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRobotML.g:211:3: this_GetSensor_6= ruleGetSensor
                    {

                    			newCompositeNode(grammarAccess.getExpressionAccess().getGetSensorParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetSensor_6=ruleGetSensor();

                    state._fsp--;


                    			current = this_GetSensor_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleType"
    // InternalRobotML.g:223:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalRobotML.g:223:45: (iv_ruleType= ruleType EOF )
            // InternalRobotML.g:224:2: iv_ruleType= ruleType EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalRobotML.g:230:1: ruleType returns [EObject current=null] : (this_String0_0= ruleString0 | this_Boolean_1= ruleBoolean | this_Integer_2= ruleInteger | this_Float_3= ruleFloat | this_Void_4= ruleVoid ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_String0_0 = null;

        EObject this_Boolean_1 = null;

        EObject this_Integer_2 = null;

        EObject this_Float_3 = null;

        EObject this_Void_4 = null;



        	enterRule();

        try {
            // InternalRobotML.g:236:2: ( (this_String0_0= ruleString0 | this_Boolean_1= ruleBoolean | this_Integer_2= ruleInteger | this_Float_3= ruleFloat | this_Void_4= ruleVoid ) )
            // InternalRobotML.g:237:2: (this_String0_0= ruleString0 | this_Boolean_1= ruleBoolean | this_Integer_2= ruleInteger | this_Float_3= ruleFloat | this_Void_4= ruleVoid )
            {
            // InternalRobotML.g:237:2: (this_String0_0= ruleString0 | this_Boolean_1= ruleBoolean | this_Integer_2= ruleInteger | this_Float_3= ruleFloat | this_Void_4= ruleVoid )
            int alt2=5;
            switch ( input.LA(1) ) {
            case 18:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 20:
                {
                alt2=3;
                }
                break;
            case 21:
                {
                alt2=4;
                }
                break;
            case 22:
                {
                alt2=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalRobotML.g:238:3: this_String0_0= ruleString0
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getString0ParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_String0_0=ruleString0();

                    state._fsp--;


                    			current = this_String0_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRobotML.g:247:3: this_Boolean_1= ruleBoolean
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getBooleanParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Boolean_1=ruleBoolean();

                    state._fsp--;


                    			current = this_Boolean_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRobotML.g:256:3: this_Integer_2= ruleInteger
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getIntegerParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Integer_2=ruleInteger();

                    state._fsp--;


                    			current = this_Integer_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRobotML.g:265:3: this_Float_3= ruleFloat
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getFloatParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Float_3=ruleFloat();

                    state._fsp--;


                    			current = this_Float_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRobotML.g:274:3: this_Void_4= ruleVoid
                    {

                    			newCompositeNode(grammarAccess.getTypeAccess().getVoidParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Void_4=ruleVoid();

                    state._fsp--;


                    			current = this_Void_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleStatement"
    // InternalRobotML.g:286:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalRobotML.g:286:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalRobotML.g:287:2: iv_ruleStatement= ruleStatement EOF
            {
             newCompositeNode(grammarAccess.getStatementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;

             current =iv_ruleStatement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalRobotML.g:293:1: ruleStatement returns [EObject current=null] : (this_FunctionDeclaration_0= ruleFunctionDeclaration | this_Block_1= ruleBlock | this_Assignation_2= ruleAssignation | this_VariableDeclaration_3= ruleVariableDeclaration | this_FunctionCall_4= ruleFunctionCall | this_Condition_5= ruleCondition | this_setSpeed_6= rulesetSpeed | this_SetClock_7= ruleSetClock | this_Rotate_8= ruleRotate | this_Forward_9= ruleForward | this_Backward_10= ruleBackward | this_Leftward_11= ruleLeftward | this_Rightward_12= ruleRightward ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_FunctionDeclaration_0 = null;

        EObject this_Block_1 = null;

        EObject this_Assignation_2 = null;

        EObject this_VariableDeclaration_3 = null;

        EObject this_FunctionCall_4 = null;

        EObject this_Condition_5 = null;

        EObject this_setSpeed_6 = null;

        EObject this_SetClock_7 = null;

        EObject this_Rotate_8 = null;

        EObject this_Forward_9 = null;

        EObject this_Backward_10 = null;

        EObject this_Leftward_11 = null;

        EObject this_Rightward_12 = null;



        	enterRule();

        try {
            // InternalRobotML.g:299:2: ( (this_FunctionDeclaration_0= ruleFunctionDeclaration | this_Block_1= ruleBlock | this_Assignation_2= ruleAssignation | this_VariableDeclaration_3= ruleVariableDeclaration | this_FunctionCall_4= ruleFunctionCall | this_Condition_5= ruleCondition | this_setSpeed_6= rulesetSpeed | this_SetClock_7= ruleSetClock | this_Rotate_8= ruleRotate | this_Forward_9= ruleForward | this_Backward_10= ruleBackward | this_Leftward_11= ruleLeftward | this_Rightward_12= ruleRightward ) )
            // InternalRobotML.g:300:2: (this_FunctionDeclaration_0= ruleFunctionDeclaration | this_Block_1= ruleBlock | this_Assignation_2= ruleAssignation | this_VariableDeclaration_3= ruleVariableDeclaration | this_FunctionCall_4= ruleFunctionCall | this_Condition_5= ruleCondition | this_setSpeed_6= rulesetSpeed | this_SetClock_7= ruleSetClock | this_Rotate_8= ruleRotate | this_Forward_9= ruleForward | this_Backward_10= ruleBackward | this_Leftward_11= ruleLeftward | this_Rightward_12= ruleRightward )
            {
            // InternalRobotML.g:300:2: (this_FunctionDeclaration_0= ruleFunctionDeclaration | this_Block_1= ruleBlock | this_Assignation_2= ruleAssignation | this_VariableDeclaration_3= ruleVariableDeclaration | this_FunctionCall_4= ruleFunctionCall | this_Condition_5= ruleCondition | this_setSpeed_6= rulesetSpeed | this_SetClock_7= ruleSetClock | this_Rotate_8= ruleRotate | this_Forward_9= ruleForward | this_Backward_10= ruleBackward | this_Leftward_11= ruleLeftward | this_Rightward_12= ruleRightward )
            int alt3=13;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt3=1;
                }
                break;
            case 44:
                {
                alt3=2;
                }
                break;
            case 11:
                {
                alt3=3;
                }
                break;
            case 16:
                {
                alt3=4;
                }
                break;
            case 23:
                {
                alt3=5;
                }
                break;
            case 46:
                {
                alt3=6;
                }
                break;
            case 48:
                {
                alt3=7;
                }
                break;
            case 49:
                {
                alt3=8;
                }
                break;
            case 50:
                {
                alt3=9;
                }
                break;
            case 51:
                {
                alt3=10;
                }
                break;
            case 52:
                {
                alt3=11;
                }
                break;
            case 53:
                {
                alt3=12;
                }
                break;
            case 54:
                {
                alt3=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }

            switch (alt3) {
                case 1 :
                    // InternalRobotML.g:301:3: this_FunctionDeclaration_0= ruleFunctionDeclaration
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getFunctionDeclarationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionDeclaration_0=ruleFunctionDeclaration();

                    state._fsp--;


                    			current = this_FunctionDeclaration_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalRobotML.g:310:3: this_Block_1= ruleBlock
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getBlockParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Block_1=ruleBlock();

                    state._fsp--;


                    			current = this_Block_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalRobotML.g:319:3: this_Assignation_2= ruleAssignation
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getAssignationParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Assignation_2=ruleAssignation();

                    state._fsp--;


                    			current = this_Assignation_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalRobotML.g:328:3: this_VariableDeclaration_3= ruleVariableDeclaration
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_3=ruleVariableDeclaration();

                    state._fsp--;


                    			current = this_VariableDeclaration_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalRobotML.g:337:3: this_FunctionCall_4= ruleFunctionCall
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getFunctionCallParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_4=ruleFunctionCall();

                    state._fsp--;


                    			current = this_FunctionCall_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalRobotML.g:346:3: this_Condition_5= ruleCondition
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getConditionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Condition_5=ruleCondition();

                    state._fsp--;


                    			current = this_Condition_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalRobotML.g:355:3: this_setSpeed_6= rulesetSpeed
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSetSpeedParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_setSpeed_6=rulesetSpeed();

                    state._fsp--;


                    			current = this_setSpeed_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalRobotML.g:364:3: this_SetClock_7= ruleSetClock
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getSetClockParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_SetClock_7=ruleSetClock();

                    state._fsp--;


                    			current = this_SetClock_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalRobotML.g:373:3: this_Rotate_8= ruleRotate
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getRotateParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rotate_8=ruleRotate();

                    state._fsp--;


                    			current = this_Rotate_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalRobotML.g:382:3: this_Forward_9= ruleForward
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getForwardParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Forward_9=ruleForward();

                    state._fsp--;


                    			current = this_Forward_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 11 :
                    // InternalRobotML.g:391:3: this_Backward_10= ruleBackward
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getBackwardParserRuleCall_10());
                    		
                    pushFollow(FOLLOW_2);
                    this_Backward_10=ruleBackward();

                    state._fsp--;


                    			current = this_Backward_10;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 12 :
                    // InternalRobotML.g:400:3: this_Leftward_11= ruleLeftward
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getLeftwardParserRuleCall_11());
                    		
                    pushFollow(FOLLOW_2);
                    this_Leftward_11=ruleLeftward();

                    state._fsp--;


                    			current = this_Leftward_11;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 13 :
                    // InternalRobotML.g:409:3: this_Rightward_12= ruleRightward
                    {

                    			newCompositeNode(grammarAccess.getStatementAccess().getRightwardParserRuleCall_12());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rightward_12=ruleRightward();

                    state._fsp--;


                    			current = this_Rightward_12;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalRobotML.g:421:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalRobotML.g:421:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalRobotML.g:422:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
             newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;

             current =iv_ruleVariableDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalRobotML.g:428:1: ruleVariableDeclaration returns [EObject current=null] : ( () otherlv_1= 'VariableDeclaration' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )? otherlv_6= '}' ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:434:2: ( ( () otherlv_1= 'VariableDeclaration' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )? otherlv_6= '}' ) )
            // InternalRobotML.g:435:2: ( () otherlv_1= 'VariableDeclaration' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )? otherlv_6= '}' )
            {
            // InternalRobotML.g:435:2: ( () otherlv_1= 'VariableDeclaration' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )? otherlv_6= '}' )
            // InternalRobotML.g:436:3: () otherlv_1= 'VariableDeclaration' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )? otherlv_6= '}'
            {
            // InternalRobotML.g:436:3: ()
            // InternalRobotML.g:437:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,16,FOLLOW_9); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableDeclarationAccess().getVariableDeclarationKeyword_1());
            		
            // InternalRobotML.g:447:3: ( (lv_name_2_0= ruleEString ) )
            // InternalRobotML.g:448:4: (lv_name_2_0= ruleEString )
            {
            // InternalRobotML.g:448:4: (lv_name_2_0= ruleEString )
            // InternalRobotML.g:449:5: lv_name_2_0= ruleEString
            {

            					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getNameEStringParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_3);
            lv_name_2_0=ruleEString();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.robotml.RobotML.EString");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_10); 

            			newLeafNode(otherlv_3, grammarAccess.getVariableDeclarationAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalRobotML.g:470:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleType ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalRobotML.g:471:4: otherlv_4= 'type' ( (lv_type_5_0= ruleType ) )
                    {
                    otherlv_4=(Token)match(input,17,FOLLOW_11); 

                    				newLeafNode(otherlv_4, grammarAccess.getVariableDeclarationAccess().getTypeKeyword_4_0());
                    			
                    // InternalRobotML.g:475:4: ( (lv_type_5_0= ruleType ) )
                    // InternalRobotML.g:476:5: (lv_type_5_0= ruleType )
                    {
                    // InternalRobotML.g:476:5: (lv_type_5_0= ruleType )
                    // InternalRobotML.g:477:6: lv_type_5_0= ruleType
                    {

                    						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTypeParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_8);
                    lv_type_5_0=ruleType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
                    							"org.xtext.robotml.RobotML.Type");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleEString"
    // InternalRobotML.g:503:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // InternalRobotML.g:503:47: (iv_ruleEString= ruleEString EOF )
            // InternalRobotML.g:504:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // InternalRobotML.g:510:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:516:2: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // InternalRobotML.g:517:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // InternalRobotML.g:517:2: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalRobotML.g:518:3: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    			current.merge(this_STRING_0);
                    		

                    			newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalRobotML.g:526:3: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_1);
                    		

                    			newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleString0"
    // InternalRobotML.g:537:1: entryRuleString0 returns [EObject current=null] : iv_ruleString0= ruleString0 EOF ;
    public final EObject entryRuleString0() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleString0 = null;


        try {
            // InternalRobotML.g:537:48: (iv_ruleString0= ruleString0 EOF )
            // InternalRobotML.g:538:2: iv_ruleString0= ruleString0 EOF
            {
             newCompositeNode(grammarAccess.getString0Rule()); 
            pushFollow(FOLLOW_1);
            iv_ruleString0=ruleString0();

            state._fsp--;

             current =iv_ruleString0; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleString0"


    // $ANTLR start "ruleString0"
    // InternalRobotML.g:544:1: ruleString0 returns [EObject current=null] : ( () otherlv_1= 'String' ) ;
    public final EObject ruleString0() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:550:2: ( ( () otherlv_1= 'String' ) )
            // InternalRobotML.g:551:2: ( () otherlv_1= 'String' )
            {
            // InternalRobotML.g:551:2: ( () otherlv_1= 'String' )
            // InternalRobotML.g:552:3: () otherlv_1= 'String'
            {
            // InternalRobotML.g:552:3: ()
            // InternalRobotML.g:553:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getString0Access().getStringAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,18,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getString0Access().getStringKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleString0"


    // $ANTLR start "entryRuleBoolean"
    // InternalRobotML.g:567:1: entryRuleBoolean returns [EObject current=null] : iv_ruleBoolean= ruleBoolean EOF ;
    public final EObject entryRuleBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoolean = null;


        try {
            // InternalRobotML.g:567:48: (iv_ruleBoolean= ruleBoolean EOF )
            // InternalRobotML.g:568:2: iv_ruleBoolean= ruleBoolean EOF
            {
             newCompositeNode(grammarAccess.getBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoolean=ruleBoolean();

            state._fsp--;

             current =iv_ruleBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoolean"


    // $ANTLR start "ruleBoolean"
    // InternalRobotML.g:574:1: ruleBoolean returns [EObject current=null] : ( () otherlv_1= 'Boolean' ) ;
    public final EObject ruleBoolean() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:580:2: ( ( () otherlv_1= 'Boolean' ) )
            // InternalRobotML.g:581:2: ( () otherlv_1= 'Boolean' )
            {
            // InternalRobotML.g:581:2: ( () otherlv_1= 'Boolean' )
            // InternalRobotML.g:582:3: () otherlv_1= 'Boolean'
            {
            // InternalRobotML.g:582:3: ()
            // InternalRobotML.g:583:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBooleanAccess().getBooleanAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getBooleanAccess().getBooleanKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoolean"


    // $ANTLR start "entryRuleInteger"
    // InternalRobotML.g:597:1: entryRuleInteger returns [EObject current=null] : iv_ruleInteger= ruleInteger EOF ;
    public final EObject entryRuleInteger() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInteger = null;


        try {
            // InternalRobotML.g:597:48: (iv_ruleInteger= ruleInteger EOF )
            // InternalRobotML.g:598:2: iv_ruleInteger= ruleInteger EOF
            {
             newCompositeNode(grammarAccess.getIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInteger=ruleInteger();

            state._fsp--;

             current =iv_ruleInteger; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInteger"


    // $ANTLR start "ruleInteger"
    // InternalRobotML.g:604:1: ruleInteger returns [EObject current=null] : ( () otherlv_1= 'Integer' ) ;
    public final EObject ruleInteger() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:610:2: ( ( () otherlv_1= 'Integer' ) )
            // InternalRobotML.g:611:2: ( () otherlv_1= 'Integer' )
            {
            // InternalRobotML.g:611:2: ( () otherlv_1= 'Integer' )
            // InternalRobotML.g:612:3: () otherlv_1= 'Integer'
            {
            // InternalRobotML.g:612:3: ()
            // InternalRobotML.g:613:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIntegerAccess().getIntegerAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getIntegerAccess().getIntegerKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInteger"


    // $ANTLR start "entryRuleFloat"
    // InternalRobotML.g:627:1: entryRuleFloat returns [EObject current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final EObject entryRuleFloat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloat = null;


        try {
            // InternalRobotML.g:627:46: (iv_ruleFloat= ruleFloat EOF )
            // InternalRobotML.g:628:2: iv_ruleFloat= ruleFloat EOF
            {
             newCompositeNode(grammarAccess.getFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;

             current =iv_ruleFloat; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalRobotML.g:634:1: ruleFloat returns [EObject current=null] : ( () otherlv_1= 'Float' ) ;
    public final EObject ruleFloat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:640:2: ( ( () otherlv_1= 'Float' ) )
            // InternalRobotML.g:641:2: ( () otherlv_1= 'Float' )
            {
            // InternalRobotML.g:641:2: ( () otherlv_1= 'Float' )
            // InternalRobotML.g:642:3: () otherlv_1= 'Float'
            {
            // InternalRobotML.g:642:3: ()
            // InternalRobotML.g:643:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getFloatAccess().getFloatAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,21,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getFloatAccess().getFloatKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleVoid"
    // InternalRobotML.g:657:1: entryRuleVoid returns [EObject current=null] : iv_ruleVoid= ruleVoid EOF ;
    public final EObject entryRuleVoid() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVoid = null;


        try {
            // InternalRobotML.g:657:45: (iv_ruleVoid= ruleVoid EOF )
            // InternalRobotML.g:658:2: iv_ruleVoid= ruleVoid EOF
            {
             newCompositeNode(grammarAccess.getVoidRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVoid=ruleVoid();

            state._fsp--;

             current =iv_ruleVoid; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVoid"


    // $ANTLR start "ruleVoid"
    // InternalRobotML.g:664:1: ruleVoid returns [EObject current=null] : ( () otherlv_1= 'Void' ) ;
    public final EObject ruleVoid() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:670:2: ( ( () otherlv_1= 'Void' ) )
            // InternalRobotML.g:671:2: ( () otherlv_1= 'Void' )
            {
            // InternalRobotML.g:671:2: ( () otherlv_1= 'Void' )
            // InternalRobotML.g:672:3: () otherlv_1= 'Void'
            {
            // InternalRobotML.g:672:3: ()
            // InternalRobotML.g:673:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getVoidAccess().getVoidAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_1, grammarAccess.getVoidAccess().getVoidKeyword_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVoid"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalRobotML.g:687:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalRobotML.g:687:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalRobotML.g:688:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
             newCompositeNode(grammarAccess.getFunctionCallRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;

             current =iv_ruleFunctionCall; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalRobotML.g:694:1: ruleFunctionCall returns [EObject current=null] : (otherlv_0= 'FunctionCall' otherlv_1= '{' otherlv_2= 'functiondeclaration' ( ( ruleEString ) ) (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= 'expresion' ( (lv_expresion_11_0= ruleVariableDeclaration ) ) otherlv_12= '}' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_expresion_11_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:700:2: ( (otherlv_0= 'FunctionCall' otherlv_1= '{' otherlv_2= 'functiondeclaration' ( ( ruleEString ) ) (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= 'expresion' ( (lv_expresion_11_0= ruleVariableDeclaration ) ) otherlv_12= '}' ) )
            // InternalRobotML.g:701:2: (otherlv_0= 'FunctionCall' otherlv_1= '{' otherlv_2= 'functiondeclaration' ( ( ruleEString ) ) (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= 'expresion' ( (lv_expresion_11_0= ruleVariableDeclaration ) ) otherlv_12= '}' )
            {
            // InternalRobotML.g:701:2: (otherlv_0= 'FunctionCall' otherlv_1= '{' otherlv_2= 'functiondeclaration' ( ( ruleEString ) ) (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= 'expresion' ( (lv_expresion_11_0= ruleVariableDeclaration ) ) otherlv_12= '}' )
            // InternalRobotML.g:702:3: otherlv_0= 'FunctionCall' otherlv_1= '{' otherlv_2= 'functiondeclaration' ( ( ruleEString ) ) (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )? otherlv_10= 'expresion' ( (lv_expresion_11_0= ruleVariableDeclaration ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionCallKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_12); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,24,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionCallAccess().getFunctiondeclarationKeyword_2());
            		
            // InternalRobotML.g:714:3: ( ( ruleEString ) )
            // InternalRobotML.g:715:4: ( ruleEString )
            {
            // InternalRobotML.g:715:4: ( ruleEString )
            // InternalRobotML.g:716:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFunctionCallRule());
            					}
            				

            					newCompositeNode(grammarAccess.getFunctionCallAccess().getFunctiondeclarationFunctionDeclarationCrossReference_3_0());
            				
            pushFollow(FOLLOW_13);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:730:3: (otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalRobotML.g:731:4: otherlv_4= 'parameters' otherlv_5= '(' ( ( ruleEString ) ) (otherlv_7= ',' ( ( ruleEString ) ) )* otherlv_9= ')'
                    {
                    otherlv_4=(Token)match(input,25,FOLLOW_14); 

                    				newLeafNode(otherlv_4, grammarAccess.getFunctionCallAccess().getParametersKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,26,FOLLOW_9); 

                    				newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_4_1());
                    			
                    // InternalRobotML.g:739:4: ( ( ruleEString ) )
                    // InternalRobotML.g:740:5: ( ruleEString )
                    {
                    // InternalRobotML.g:740:5: ( ruleEString )
                    // InternalRobotML.g:741:6: ruleEString
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFunctionCallRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getFunctionCallAccess().getParametersExpressionCrossReference_4_2_0());
                    					
                    pushFollow(FOLLOW_15);
                    ruleEString();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRobotML.g:755:4: (otherlv_7= ',' ( ( ruleEString ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==27) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalRobotML.g:756:5: otherlv_7= ',' ( ( ruleEString ) )
                    	    {
                    	    otherlv_7=(Token)match(input,27,FOLLOW_9); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getFunctionCallAccess().getCommaKeyword_4_3_0());
                    	    				
                    	    // InternalRobotML.g:760:5: ( ( ruleEString ) )
                    	    // InternalRobotML.g:761:6: ( ruleEString )
                    	    {
                    	    // InternalRobotML.g:761:6: ( ruleEString )
                    	    // InternalRobotML.g:762:7: ruleEString
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getFunctionCallRule());
                    	    							}
                    	    						

                    	    							newCompositeNode(grammarAccess.getFunctionCallAccess().getParametersExpressionCrossReference_4_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
                    	    ruleEString();

                    	    state._fsp--;


                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_9=(Token)match(input,28,FOLLOW_16); 

                    				newLeafNode(otherlv_9, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_4_4());
                    			

                    }
                    break;

            }

            otherlv_10=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_10, grammarAccess.getFunctionCallAccess().getExpresionKeyword_5());
            		
            // InternalRobotML.g:786:3: ( (lv_expresion_11_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:787:4: (lv_expresion_11_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:787:4: (lv_expresion_11_0= ruleVariableDeclaration )
            // InternalRobotML.g:788:5: lv_expresion_11_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getFunctionCallAccess().getExpresionVariableDeclarationParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_8);
            lv_expresion_11_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionCallRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_11_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getFunctionCallAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleBinary"
    // InternalRobotML.g:813:1: entryRuleBinary returns [EObject current=null] : iv_ruleBinary= ruleBinary EOF ;
    public final EObject entryRuleBinary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinary = null;


        try {
            // InternalRobotML.g:813:47: (iv_ruleBinary= ruleBinary EOF )
            // InternalRobotML.g:814:2: iv_ruleBinary= ruleBinary EOF
            {
             newCompositeNode(grammarAccess.getBinaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinary=ruleBinary();

            state._fsp--;

             current =iv_ruleBinary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinary"


    // $ANTLR start "ruleBinary"
    // InternalRobotML.g:820:1: ruleBinary returns [EObject current=null] : (otherlv_0= 'Binary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operands' otherlv_13= '{' ( (lv_operands_14_0= ruleExpression ) ) (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )* otherlv_17= '}' otherlv_18= '}' ) ;
    public final EObject ruleBinary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Enumerator lv_Operator_3_0 = null;

        EObject lv_expresion_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject lv_expression_10_0 = null;

        EObject lv_operands_14_0 = null;

        EObject lv_operands_16_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:826:2: ( (otherlv_0= 'Binary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operands' otherlv_13= '{' ( (lv_operands_14_0= ruleExpression ) ) (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )* otherlv_17= '}' otherlv_18= '}' ) )
            // InternalRobotML.g:827:2: (otherlv_0= 'Binary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operands' otherlv_13= '{' ( (lv_operands_14_0= ruleExpression ) ) (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )* otherlv_17= '}' otherlv_18= '}' )
            {
            // InternalRobotML.g:827:2: (otherlv_0= 'Binary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operands' otherlv_13= '{' ( (lv_operands_14_0= ruleExpression ) ) (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )* otherlv_17= '}' otherlv_18= '}' )
            // InternalRobotML.g:828:3: otherlv_0= 'Binary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operands' otherlv_13= '{' ( (lv_operands_14_0= ruleExpression ) ) (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )* otherlv_17= '}' otherlv_18= '}'
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBinaryAccess().getBinaryKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getBinaryAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRobotML.g:836:3: (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==31) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalRobotML.g:837:4: otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleBinaryOp ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_18); 

                    				newLeafNode(otherlv_2, grammarAccess.getBinaryAccess().getOperatorKeyword_2_0());
                    			
                    // InternalRobotML.g:841:4: ( (lv_Operator_3_0= ruleBinaryOp ) )
                    // InternalRobotML.g:842:5: (lv_Operator_3_0= ruleBinaryOp )
                    {
                    // InternalRobotML.g:842:5: (lv_Operator_3_0= ruleBinaryOp )
                    // InternalRobotML.g:843:6: lv_Operator_3_0= ruleBinaryOp
                    {

                    						newCompositeNode(grammarAccess.getBinaryAccess().getOperatorBinaryOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_Operator_3_0=ruleBinaryOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBinaryRule());
                    						}
                    						set(
                    							current,
                    							"Operator",
                    							lv_Operator_3_0,
                    							"org.xtext.robotml.RobotML.BinaryOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getBinaryAccess().getExpresionKeyword_3());
            		
            // InternalRobotML.g:865:3: ( (lv_expresion_5_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:866:4: (lv_expresion_5_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:866:4: (lv_expresion_5_0= ruleVariableDeclaration )
            // InternalRobotML.g:867:5: lv_expresion_5_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getExpresionVariableDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_expresion_5_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_5_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getBinaryAccess().getExpressionKeyword_5());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getBinaryAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalRobotML.g:892:3: ( (lv_expression_8_0= ruleExpression ) )
            // InternalRobotML.g:893:4: (lv_expression_8_0= ruleExpression )
            {
            // InternalRobotML.g:893:4: (lv_expression_8_0= ruleExpression )
            // InternalRobotML.g:894:5: lv_expression_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getExpressionExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_19);
            lv_expression_8_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					add(
            						current,
            						"expression",
            						lv_expression_8_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:911:3: (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==27) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalRobotML.g:912:4: otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) )
            	    {
            	    otherlv_9=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_9, grammarAccess.getBinaryAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalRobotML.g:916:4: ( (lv_expression_10_0= ruleExpression ) )
            	    // InternalRobotML.g:917:5: (lv_expression_10_0= ruleExpression )
            	    {
            	    // InternalRobotML.g:917:5: (lv_expression_10_0= ruleExpression )
            	    // InternalRobotML.g:918:6: lv_expression_10_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getBinaryAccess().getExpressionExpressionParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_expression_10_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBinaryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"expression",
            	    							lv_expression_10_0,
            	    							"org.xtext.robotml.RobotML.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_20); 

            			newLeafNode(otherlv_11, grammarAccess.getBinaryAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_12=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_12, grammarAccess.getBinaryAccess().getOperandsKeyword_10());
            		
            otherlv_13=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_13, grammarAccess.getBinaryAccess().getLeftCurlyBracketKeyword_11());
            		
            // InternalRobotML.g:948:3: ( (lv_operands_14_0= ruleExpression ) )
            // InternalRobotML.g:949:4: (lv_operands_14_0= ruleExpression )
            {
            // InternalRobotML.g:949:4: (lv_operands_14_0= ruleExpression )
            // InternalRobotML.g:950:5: lv_operands_14_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBinaryAccess().getOperandsExpressionParserRuleCall_12_0());
            				
            pushFollow(FOLLOW_19);
            lv_operands_14_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBinaryRule());
            					}
            					add(
            						current,
            						"operands",
            						lv_operands_14_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:967:3: (otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalRobotML.g:968:4: otherlv_15= ',' ( (lv_operands_16_0= ruleExpression ) )
            	    {
            	    otherlv_15=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_15, grammarAccess.getBinaryAccess().getCommaKeyword_13_0());
            	    			
            	    // InternalRobotML.g:972:4: ( (lv_operands_16_0= ruleExpression ) )
            	    // InternalRobotML.g:973:5: (lv_operands_16_0= ruleExpression )
            	    {
            	    // InternalRobotML.g:973:5: (lv_operands_16_0= ruleExpression )
            	    // InternalRobotML.g:974:6: lv_operands_16_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getBinaryAccess().getOperandsExpressionParserRuleCall_13_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_operands_16_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getBinaryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operands",
            	    							lv_operands_16_0,
            	    							"org.xtext.robotml.RobotML.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_17=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_17, grammarAccess.getBinaryAccess().getRightCurlyBracketKeyword_14());
            		
            otherlv_18=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_18, grammarAccess.getBinaryAccess().getRightCurlyBracketKeyword_15());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinary"


    // $ANTLR start "entryRuleUnary"
    // InternalRobotML.g:1004:1: entryRuleUnary returns [EObject current=null] : iv_ruleUnary= ruleUnary EOF ;
    public final EObject entryRuleUnary() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnary = null;


        try {
            // InternalRobotML.g:1004:46: (iv_ruleUnary= ruleUnary EOF )
            // InternalRobotML.g:1005:2: iv_ruleUnary= ruleUnary EOF
            {
             newCompositeNode(grammarAccess.getUnaryRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUnary=ruleUnary();

            state._fsp--;

             current =iv_ruleUnary; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnary"


    // $ANTLR start "ruleUnary"
    // InternalRobotML.g:1011:1: ruleUnary returns [EObject current=null] : (otherlv_0= 'Unary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operand' ( (lv_operand_13_0= ruleExpression ) ) otherlv_14= '}' ) ;
    public final EObject ruleUnary() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Enumerator lv_Operator_3_0 = null;

        EObject lv_expresion_5_0 = null;

        EObject lv_expression_8_0 = null;

        EObject lv_expression_10_0 = null;

        EObject lv_operand_13_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1017:2: ( (otherlv_0= 'Unary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operand' ( (lv_operand_13_0= ruleExpression ) ) otherlv_14= '}' ) )
            // InternalRobotML.g:1018:2: (otherlv_0= 'Unary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operand' ( (lv_operand_13_0= ruleExpression ) ) otherlv_14= '}' )
            {
            // InternalRobotML.g:1018:2: (otherlv_0= 'Unary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operand' ( (lv_operand_13_0= ruleExpression ) ) otherlv_14= '}' )
            // InternalRobotML.g:1019:3: otherlv_0= 'Unary' otherlv_1= '{' (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= 'expression' otherlv_7= '{' ( (lv_expression_8_0= ruleExpression ) ) (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )* otherlv_11= '}' otherlv_12= 'operand' ( (lv_operand_13_0= ruleExpression ) ) otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,33,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getUnaryAccess().getUnaryKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getUnaryAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRobotML.g:1027:3: (otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==31) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalRobotML.g:1028:4: otherlv_2= 'Operator' ( (lv_Operator_3_0= ruleUnaryOp ) )
                    {
                    otherlv_2=(Token)match(input,31,FOLLOW_21); 

                    				newLeafNode(otherlv_2, grammarAccess.getUnaryAccess().getOperatorKeyword_2_0());
                    			
                    // InternalRobotML.g:1032:4: ( (lv_Operator_3_0= ruleUnaryOp ) )
                    // InternalRobotML.g:1033:5: (lv_Operator_3_0= ruleUnaryOp )
                    {
                    // InternalRobotML.g:1033:5: (lv_Operator_3_0= ruleUnaryOp )
                    // InternalRobotML.g:1034:6: lv_Operator_3_0= ruleUnaryOp
                    {

                    						newCompositeNode(grammarAccess.getUnaryAccess().getOperatorUnaryOpEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_Operator_3_0=ruleUnaryOp();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getUnaryRule());
                    						}
                    						set(
                    							current,
                    							"Operator",
                    							lv_Operator_3_0,
                    							"org.xtext.robotml.RobotML.UnaryOp");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getUnaryAccess().getExpresionKeyword_3());
            		
            // InternalRobotML.g:1056:3: ( (lv_expresion_5_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:1057:4: (lv_expresion_5_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:1057:4: (lv_expresion_5_0= ruleVariableDeclaration )
            // InternalRobotML.g:1058:5: lv_expresion_5_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getUnaryAccess().getExpresionVariableDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_6);
            lv_expresion_5_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_5_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,14,FOLLOW_3); 

            			newLeafNode(otherlv_6, grammarAccess.getUnaryAccess().getExpressionKeyword_5());
            		
            otherlv_7=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_7, grammarAccess.getUnaryAccess().getLeftCurlyBracketKeyword_6());
            		
            // InternalRobotML.g:1083:3: ( (lv_expression_8_0= ruleExpression ) )
            // InternalRobotML.g:1084:4: (lv_expression_8_0= ruleExpression )
            {
            // InternalRobotML.g:1084:4: (lv_expression_8_0= ruleExpression )
            // InternalRobotML.g:1085:5: lv_expression_8_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getUnaryAccess().getExpressionExpressionParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_19);
            lv_expression_8_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryRule());
            					}
            					add(
            						current,
            						"expression",
            						lv_expression_8_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:1102:3: (otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==27) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalRobotML.g:1103:4: otherlv_9= ',' ( (lv_expression_10_0= ruleExpression ) )
            	    {
            	    otherlv_9=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_9, grammarAccess.getUnaryAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalRobotML.g:1107:4: ( (lv_expression_10_0= ruleExpression ) )
            	    // InternalRobotML.g:1108:5: (lv_expression_10_0= ruleExpression )
            	    {
            	    // InternalRobotML.g:1108:5: (lv_expression_10_0= ruleExpression )
            	    // InternalRobotML.g:1109:6: lv_expression_10_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getUnaryAccess().getExpressionExpressionParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_expression_10_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getUnaryRule());
            	    						}
            	    						add(
            	    							current,
            	    							"expression",
            	    							lv_expression_10_0,
            	    							"org.xtext.robotml.RobotML.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_11=(Token)match(input,15,FOLLOW_22); 

            			newLeafNode(otherlv_11, grammarAccess.getUnaryAccess().getRightCurlyBracketKeyword_9());
            		
            otherlv_12=(Token)match(input,34,FOLLOW_7); 

            			newLeafNode(otherlv_12, grammarAccess.getUnaryAccess().getOperandKeyword_10());
            		
            // InternalRobotML.g:1135:3: ( (lv_operand_13_0= ruleExpression ) )
            // InternalRobotML.g:1136:4: (lv_operand_13_0= ruleExpression )
            {
            // InternalRobotML.g:1136:4: (lv_operand_13_0= ruleExpression )
            // InternalRobotML.g:1137:5: lv_operand_13_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getUnaryAccess().getOperandExpressionParserRuleCall_11_0());
            				
            pushFollow(FOLLOW_8);
            lv_operand_13_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUnaryRule());
            					}
            					set(
            						current,
            						"operand",
            						lv_operand_13_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_14=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getUnaryAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnary"


    // $ANTLR start "entryRuleVariableRef"
    // InternalRobotML.g:1162:1: entryRuleVariableRef returns [EObject current=null] : iv_ruleVariableRef= ruleVariableRef EOF ;
    public final EObject entryRuleVariableRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableRef = null;


        try {
            // InternalRobotML.g:1162:52: (iv_ruleVariableRef= ruleVariableRef EOF )
            // InternalRobotML.g:1163:2: iv_ruleVariableRef= ruleVariableRef EOF
            {
             newCompositeNode(grammarAccess.getVariableRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariableRef=ruleVariableRef();

            state._fsp--;

             current =iv_ruleVariableRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableRef"


    // $ANTLR start "ruleVariableRef"
    // InternalRobotML.g:1169:1: ruleVariableRef returns [EObject current=null] : (otherlv_0= 'VariableRef' otherlv_1= '{' otherlv_2= 'ref' ( ( ruleEString ) ) otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' ) ;
    public final EObject ruleVariableRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expresion_5_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1175:2: ( (otherlv_0= 'VariableRef' otherlv_1= '{' otherlv_2= 'ref' ( ( ruleEString ) ) otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' ) )
            // InternalRobotML.g:1176:2: (otherlv_0= 'VariableRef' otherlv_1= '{' otherlv_2= 'ref' ( ( ruleEString ) ) otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' )
            {
            // InternalRobotML.g:1176:2: (otherlv_0= 'VariableRef' otherlv_1= '{' otherlv_2= 'ref' ( ( ruleEString ) ) otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' )
            // InternalRobotML.g:1177:3: otherlv_0= 'VariableRef' otherlv_1= '{' otherlv_2= 'ref' ( ( ruleEString ) ) otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getVariableRefAccess().getVariableRefKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getVariableRefAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,36,FOLLOW_9); 

            			newLeafNode(otherlv_2, grammarAccess.getVariableRefAccess().getRefKeyword_2());
            		
            // InternalRobotML.g:1189:3: ( ( ruleEString ) )
            // InternalRobotML.g:1190:4: ( ruleEString )
            {
            // InternalRobotML.g:1190:4: ( ruleEString )
            // InternalRobotML.g:1191:5: ruleEString
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getVariableRefRule());
            					}
            				

            					newCompositeNode(grammarAccess.getVariableRefAccess().getRefVariableDeclarationCrossReference_3_0());
            				
            pushFollow(FOLLOW_16);
            ruleEString();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getVariableRefAccess().getExpresionKeyword_4());
            		
            // InternalRobotML.g:1209:3: ( (lv_expresion_5_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:1210:4: (lv_expresion_5_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:1210:4: (lv_expresion_5_0= ruleVariableDeclaration )
            // InternalRobotML.g:1211:5: lv_expresion_5_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getVariableRefAccess().getExpresionVariableDeclarationParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_8);
            lv_expresion_5_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRefRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_5_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getVariableRefAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableRef"


    // $ANTLR start "entryRuleGetSpeed"
    // InternalRobotML.g:1236:1: entryRuleGetSpeed returns [EObject current=null] : iv_ruleGetSpeed= ruleGetSpeed EOF ;
    public final EObject entryRuleGetSpeed() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetSpeed = null;


        try {
            // InternalRobotML.g:1236:49: (iv_ruleGetSpeed= ruleGetSpeed EOF )
            // InternalRobotML.g:1237:2: iv_ruleGetSpeed= ruleGetSpeed EOF
            {
             newCompositeNode(grammarAccess.getGetSpeedRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetSpeed=ruleGetSpeed();

            state._fsp--;

             current =iv_ruleGetSpeed; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetSpeed"


    // $ANTLR start "ruleGetSpeed"
    // InternalRobotML.g:1243:1: ruleGetSpeed returns [EObject current=null] : (otherlv_0= 'GetSpeed' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' ) ;
    public final EObject ruleGetSpeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1249:2: ( (otherlv_0= 'GetSpeed' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1250:2: (otherlv_0= 'GetSpeed' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1250:2: (otherlv_0= 'GetSpeed' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' )
            // InternalRobotML.g:1251:3: otherlv_0= 'GetSpeed' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGetSpeedAccess().getGetSpeedKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getGetSpeedAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGetSpeedAccess().getExpresionKeyword_2());
            		
            // InternalRobotML.g:1263:3: ( (lv_expresion_3_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:1264:4: (lv_expresion_3_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:1264:4: (lv_expresion_3_0= ruleVariableDeclaration )
            // InternalRobotML.g:1265:5: lv_expresion_3_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getGetSpeedAccess().getExpresionVariableDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expresion_3_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetSpeedRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_3_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGetSpeedAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetSpeed"


    // $ANTLR start "entryRuleGetClock"
    // InternalRobotML.g:1290:1: entryRuleGetClock returns [EObject current=null] : iv_ruleGetClock= ruleGetClock EOF ;
    public final EObject entryRuleGetClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetClock = null;


        try {
            // InternalRobotML.g:1290:49: (iv_ruleGetClock= ruleGetClock EOF )
            // InternalRobotML.g:1291:2: iv_ruleGetClock= ruleGetClock EOF
            {
             newCompositeNode(grammarAccess.getGetClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetClock=ruleGetClock();

            state._fsp--;

             current =iv_ruleGetClock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetClock"


    // $ANTLR start "ruleGetClock"
    // InternalRobotML.g:1297:1: ruleGetClock returns [EObject current=null] : (otherlv_0= 'GetClock' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' ) ;
    public final EObject ruleGetClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expresion_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1303:2: ( (otherlv_0= 'GetClock' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1304:2: (otherlv_0= 'GetClock' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1304:2: (otherlv_0= 'GetClock' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}' )
            // InternalRobotML.g:1305:3: otherlv_0= 'GetClock' otherlv_1= '{' otherlv_2= 'expresion' ( (lv_expresion_3_0= ruleVariableDeclaration ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGetClockAccess().getGetClockKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_16); 

            			newLeafNode(otherlv_1, grammarAccess.getGetClockAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getGetClockAccess().getExpresionKeyword_2());
            		
            // InternalRobotML.g:1317:3: ( (lv_expresion_3_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:1318:4: (lv_expresion_3_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:1318:4: (lv_expresion_3_0= ruleVariableDeclaration )
            // InternalRobotML.g:1319:5: lv_expresion_3_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getGetClockAccess().getExpresionVariableDeclarationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expresion_3_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetClockRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_3_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getGetClockAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetClock"


    // $ANTLR start "entryRuleGetSensor"
    // InternalRobotML.g:1344:1: entryRuleGetSensor returns [EObject current=null] : iv_ruleGetSensor= ruleGetSensor EOF ;
    public final EObject entryRuleGetSensor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetSensor = null;


        try {
            // InternalRobotML.g:1344:50: (iv_ruleGetSensor= ruleGetSensor EOF )
            // InternalRobotML.g:1345:2: iv_ruleGetSensor= ruleGetSensor EOF
            {
             newCompositeNode(grammarAccess.getGetSensorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetSensor=ruleGetSensor();

            state._fsp--;

             current =iv_ruleGetSensor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetSensor"


    // $ANTLR start "ruleGetSensor"
    // InternalRobotML.g:1351:1: ruleGetSensor returns [EObject current=null] : (otherlv_0= 'GetSensor' otherlv_1= '{' (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' ) ;
    public final EObject ruleGetSensor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_sensor_3_0 = null;

        EObject lv_expresion_5_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1357:2: ( (otherlv_0= 'GetSensor' otherlv_1= '{' (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' ) )
            // InternalRobotML.g:1358:2: (otherlv_0= 'GetSensor' otherlv_1= '{' (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' )
            {
            // InternalRobotML.g:1358:2: (otherlv_0= 'GetSensor' otherlv_1= '{' (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}' )
            // InternalRobotML.g:1359:3: otherlv_0= 'GetSensor' otherlv_1= '{' (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )? otherlv_4= 'expresion' ( (lv_expresion_5_0= ruleVariableDeclaration ) ) otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGetSensorAccess().getGetSensorKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_24); 

            			newLeafNode(otherlv_1, grammarAccess.getGetSensorAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalRobotML.g:1367:3: (otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==40) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalRobotML.g:1368:4: otherlv_2= 'sensor' ( (lv_sensor_3_0= ruleSensor ) )
                    {
                    otherlv_2=(Token)match(input,40,FOLLOW_25); 

                    				newLeafNode(otherlv_2, grammarAccess.getGetSensorAccess().getSensorKeyword_2_0());
                    			
                    // InternalRobotML.g:1372:4: ( (lv_sensor_3_0= ruleSensor ) )
                    // InternalRobotML.g:1373:5: (lv_sensor_3_0= ruleSensor )
                    {
                    // InternalRobotML.g:1373:5: (lv_sensor_3_0= ruleSensor )
                    // InternalRobotML.g:1374:6: lv_sensor_3_0= ruleSensor
                    {

                    						newCompositeNode(grammarAccess.getGetSensorAccess().getSensorSensorEnumRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_sensor_3_0=ruleSensor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getGetSensorRule());
                    						}
                    						set(
                    							current,
                    							"sensor",
                    							lv_sensor_3_0,
                    							"org.xtext.robotml.RobotML.Sensor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,29,FOLLOW_5); 

            			newLeafNode(otherlv_4, grammarAccess.getGetSensorAccess().getExpresionKeyword_3());
            		
            // InternalRobotML.g:1396:3: ( (lv_expresion_5_0= ruleVariableDeclaration ) )
            // InternalRobotML.g:1397:4: (lv_expresion_5_0= ruleVariableDeclaration )
            {
            // InternalRobotML.g:1397:4: (lv_expresion_5_0= ruleVariableDeclaration )
            // InternalRobotML.g:1398:5: lv_expresion_5_0= ruleVariableDeclaration
            {

            					newCompositeNode(grammarAccess.getGetSensorAccess().getExpresionVariableDeclarationParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_8);
            lv_expresion_5_0=ruleVariableDeclaration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetSensorRule());
            					}
            					set(
            						current,
            						"expresion",
            						lv_expresion_5_0,
            						"org.xtext.robotml.RobotML.VariableDeclaration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_6=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getGetSensorAccess().getRightCurlyBracketKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetSensor"


    // $ANTLR start "entryRuleFunctionDeclaration"
    // InternalRobotML.g:1423:1: entryRuleFunctionDeclaration returns [EObject current=null] : iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF ;
    public final EObject entryRuleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionDeclaration = null;


        try {
            // InternalRobotML.g:1423:60: (iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF )
            // InternalRobotML.g:1424:2: iv_ruleFunctionDeclaration= ruleFunctionDeclaration EOF
            {
             newCompositeNode(grammarAccess.getFunctionDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFunctionDeclaration=ruleFunctionDeclaration();

            state._fsp--;

             current =iv_ruleFunctionDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionDeclaration"


    // $ANTLR start "ruleFunctionDeclaration"
    // InternalRobotML.g:1430:1: ruleFunctionDeclaration returns [EObject current=null] : (otherlv_0= 'FunctionDeclaration' otherlv_1= '{' otherlv_2= 'returnType' ( (lv_returnType_3_0= ruleType ) ) otherlv_4= 'block' ( (lv_block_5_0= ruleBlock ) ) (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )? otherlv_12= '}' ) ;
    public final EObject ruleFunctionDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        EObject lv_returnType_3_0 = null;

        EObject lv_block_5_0 = null;

        EObject lv_parameters_8_0 = null;

        EObject lv_parameters_10_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1436:2: ( (otherlv_0= 'FunctionDeclaration' otherlv_1= '{' otherlv_2= 'returnType' ( (lv_returnType_3_0= ruleType ) ) otherlv_4= 'block' ( (lv_block_5_0= ruleBlock ) ) (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )? otherlv_12= '}' ) )
            // InternalRobotML.g:1437:2: (otherlv_0= 'FunctionDeclaration' otherlv_1= '{' otherlv_2= 'returnType' ( (lv_returnType_3_0= ruleType ) ) otherlv_4= 'block' ( (lv_block_5_0= ruleBlock ) ) (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )? otherlv_12= '}' )
            {
            // InternalRobotML.g:1437:2: (otherlv_0= 'FunctionDeclaration' otherlv_1= '{' otherlv_2= 'returnType' ( (lv_returnType_3_0= ruleType ) ) otherlv_4= 'block' ( (lv_block_5_0= ruleBlock ) ) (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )? otherlv_12= '}' )
            // InternalRobotML.g:1438:3: otherlv_0= 'FunctionDeclaration' otherlv_1= '{' otherlv_2= 'returnType' ( (lv_returnType_3_0= ruleType ) ) otherlv_4= 'block' ( (lv_block_5_0= ruleBlock ) ) (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )? otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFunctionDeclarationAccess().getFunctionDeclarationKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_26); 

            			newLeafNode(otherlv_1, grammarAccess.getFunctionDeclarationAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,42,FOLLOW_11); 

            			newLeafNode(otherlv_2, grammarAccess.getFunctionDeclarationAccess().getReturnTypeKeyword_2());
            		
            // InternalRobotML.g:1450:3: ( (lv_returnType_3_0= ruleType ) )
            // InternalRobotML.g:1451:4: (lv_returnType_3_0= ruleType )
            {
            // InternalRobotML.g:1451:4: (lv_returnType_3_0= ruleType )
            // InternalRobotML.g:1452:5: lv_returnType_3_0= ruleType
            {

            					newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getReturnTypeTypeParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_27);
            lv_returnType_3_0=ruleType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            					}
            					set(
            						current,
            						"returnType",
            						lv_returnType_3_0,
            						"org.xtext.robotml.RobotML.Type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,43,FOLLOW_28); 

            			newLeafNode(otherlv_4, grammarAccess.getFunctionDeclarationAccess().getBlockKeyword_4());
            		
            // InternalRobotML.g:1473:3: ( (lv_block_5_0= ruleBlock ) )
            // InternalRobotML.g:1474:4: (lv_block_5_0= ruleBlock )
            {
            // InternalRobotML.g:1474:4: (lv_block_5_0= ruleBlock )
            // InternalRobotML.g:1475:5: lv_block_5_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getBlockBlockParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_29);
            lv_block_5_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
            					}
            					set(
            						current,
            						"block",
            						lv_block_5_0,
            						"org.xtext.robotml.RobotML.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:1492:3: (otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==25) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalRobotML.g:1493:4: otherlv_6= 'parameters' otherlv_7= '{' ( (lv_parameters_8_0= ruleVariableDeclaration ) ) (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )* otherlv_11= '}'
                    {
                    otherlv_6=(Token)match(input,25,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getFunctionDeclarationAccess().getParametersKeyword_6_0());
                    			
                    otherlv_7=(Token)match(input,12,FOLLOW_5); 

                    				newLeafNode(otherlv_7, grammarAccess.getFunctionDeclarationAccess().getLeftCurlyBracketKeyword_6_1());
                    			
                    // InternalRobotML.g:1501:4: ( (lv_parameters_8_0= ruleVariableDeclaration ) )
                    // InternalRobotML.g:1502:5: (lv_parameters_8_0= ruleVariableDeclaration )
                    {
                    // InternalRobotML.g:1502:5: (lv_parameters_8_0= ruleVariableDeclaration )
                    // InternalRobotML.g:1503:6: lv_parameters_8_0= ruleVariableDeclaration
                    {

                    						newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersVariableDeclarationParserRuleCall_6_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_parameters_8_0=ruleVariableDeclaration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    						}
                    						add(
                    							current,
                    							"parameters",
                    							lv_parameters_8_0,
                    							"org.xtext.robotml.RobotML.VariableDeclaration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRobotML.g:1520:4: (otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) ) )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==27) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // InternalRobotML.g:1521:5: otherlv_9= ',' ( (lv_parameters_10_0= ruleVariableDeclaration ) )
                    	    {
                    	    otherlv_9=(Token)match(input,27,FOLLOW_5); 

                    	    					newLeafNode(otherlv_9, grammarAccess.getFunctionDeclarationAccess().getCommaKeyword_6_3_0());
                    	    				
                    	    // InternalRobotML.g:1525:5: ( (lv_parameters_10_0= ruleVariableDeclaration ) )
                    	    // InternalRobotML.g:1526:6: (lv_parameters_10_0= ruleVariableDeclaration )
                    	    {
                    	    // InternalRobotML.g:1526:6: (lv_parameters_10_0= ruleVariableDeclaration )
                    	    // InternalRobotML.g:1527:7: lv_parameters_10_0= ruleVariableDeclaration
                    	    {

                    	    							newCompositeNode(grammarAccess.getFunctionDeclarationAccess().getParametersVariableDeclarationParserRuleCall_6_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_parameters_10_0=ruleVariableDeclaration();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getFunctionDeclarationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"parameters",
                    	    								lv_parameters_10_0,
                    	    								"org.xtext.robotml.RobotML.VariableDeclaration");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    otherlv_11=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_11, grammarAccess.getFunctionDeclarationAccess().getRightCurlyBracketKeyword_6_4());
                    			

                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getFunctionDeclarationAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionDeclaration"


    // $ANTLR start "entryRuleBlock"
    // InternalRobotML.g:1558:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalRobotML.g:1558:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalRobotML.g:1559:2: iv_ruleBlock= ruleBlock EOF
            {
             newCompositeNode(grammarAccess.getBlockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;

             current =iv_ruleBlock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalRobotML.g:1565:1: ruleBlock returns [EObject current=null] : ( () otherlv_1= 'Block' otherlv_2= '{' (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        EObject lv_statements_5_0 = null;

        EObject lv_statements_7_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1571:2: ( ( () otherlv_1= 'Block' otherlv_2= '{' (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' ) )
            // InternalRobotML.g:1572:2: ( () otherlv_1= 'Block' otherlv_2= '{' (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            {
            // InternalRobotML.g:1572:2: ( () otherlv_1= 'Block' otherlv_2= '{' (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}' )
            // InternalRobotML.g:1573:3: () otherlv_1= 'Block' otherlv_2= '{' (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )? otherlv_9= '}'
            {
            // InternalRobotML.g:1573:3: ()
            // InternalRobotML.g:1574:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getBlockAccess().getBlockAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,44,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getBlockAccess().getBlockKeyword_1());
            		
            otherlv_2=(Token)match(input,12,FOLLOW_30); 

            			newLeafNode(otherlv_2, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalRobotML.g:1588:3: (otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}' )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==45) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalRobotML.g:1589:4: otherlv_3= 'statements' otherlv_4= '{' ( (lv_statements_5_0= ruleStatement ) ) (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )* otherlv_8= '}'
                    {
                    otherlv_3=(Token)match(input,45,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getBlockAccess().getStatementsKeyword_3_0());
                    			
                    otherlv_4=(Token)match(input,12,FOLLOW_31); 

                    				newLeafNode(otherlv_4, grammarAccess.getBlockAccess().getLeftCurlyBracketKeyword_3_1());
                    			
                    // InternalRobotML.g:1597:4: ( (lv_statements_5_0= ruleStatement ) )
                    // InternalRobotML.g:1598:5: (lv_statements_5_0= ruleStatement )
                    {
                    // InternalRobotML.g:1598:5: (lv_statements_5_0= ruleStatement )
                    // InternalRobotML.g:1599:6: lv_statements_5_0= ruleStatement
                    {

                    						newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_3_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_statements_5_0=ruleStatement();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBlockRule());
                    						}
                    						add(
                    							current,
                    							"statements",
                    							lv_statements_5_0,
                    							"org.xtext.robotml.RobotML.Statement");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalRobotML.g:1616:4: (otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==27) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // InternalRobotML.g:1617:5: otherlv_6= ',' ( (lv_statements_7_0= ruleStatement ) )
                    	    {
                    	    otherlv_6=(Token)match(input,27,FOLLOW_31); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getBlockAccess().getCommaKeyword_3_3_0());
                    	    				
                    	    // InternalRobotML.g:1621:5: ( (lv_statements_7_0= ruleStatement ) )
                    	    // InternalRobotML.g:1622:6: (lv_statements_7_0= ruleStatement )
                    	    {
                    	    // InternalRobotML.g:1622:6: (lv_statements_7_0= ruleStatement )
                    	    // InternalRobotML.g:1623:7: lv_statements_7_0= ruleStatement
                    	    {

                    	    							newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_3_3_1_0());
                    	    						
                    	    pushFollow(FOLLOW_19);
                    	    lv_statements_7_0=ruleStatement();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getBlockRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"statements",
                    	    								lv_statements_7_0,
                    	    								"org.xtext.robotml.RobotML.Statement");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,15,FOLLOW_8); 

                    				newLeafNode(otherlv_8, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_3_4());
                    			

                    }
                    break;

            }

            otherlv_9=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getBlockAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleCondition"
    // InternalRobotML.g:1654:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalRobotML.g:1654:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalRobotML.g:1655:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalRobotML.g:1661:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'Condition' otherlv_1= '{' otherlv_2= 'block' otherlv_3= '{' ( (lv_block_4_0= ruleBlock ) ) (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )* otherlv_7= '}' otherlv_8= 'conditions' otherlv_9= '{' ( (lv_conditions_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )* otherlv_13= '}' otherlv_14= '}' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        EObject lv_block_4_0 = null;

        EObject lv_block_6_0 = null;

        EObject lv_conditions_10_0 = null;

        EObject lv_conditions_12_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1667:2: ( (otherlv_0= 'Condition' otherlv_1= '{' otherlv_2= 'block' otherlv_3= '{' ( (lv_block_4_0= ruleBlock ) ) (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )* otherlv_7= '}' otherlv_8= 'conditions' otherlv_9= '{' ( (lv_conditions_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )* otherlv_13= '}' otherlv_14= '}' ) )
            // InternalRobotML.g:1668:2: (otherlv_0= 'Condition' otherlv_1= '{' otherlv_2= 'block' otherlv_3= '{' ( (lv_block_4_0= ruleBlock ) ) (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )* otherlv_7= '}' otherlv_8= 'conditions' otherlv_9= '{' ( (lv_conditions_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )* otherlv_13= '}' otherlv_14= '}' )
            {
            // InternalRobotML.g:1668:2: (otherlv_0= 'Condition' otherlv_1= '{' otherlv_2= 'block' otherlv_3= '{' ( (lv_block_4_0= ruleBlock ) ) (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )* otherlv_7= '}' otherlv_8= 'conditions' otherlv_9= '{' ( (lv_conditions_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )* otherlv_13= '}' otherlv_14= '}' )
            // InternalRobotML.g:1669:3: otherlv_0= 'Condition' otherlv_1= '{' otherlv_2= 'block' otherlv_3= '{' ( (lv_block_4_0= ruleBlock ) ) (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )* otherlv_7= '}' otherlv_8= 'conditions' otherlv_9= '{' ( (lv_conditions_10_0= ruleExpression ) ) (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )* otherlv_13= '}' otherlv_14= '}'
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,43,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getBlockKeyword_2());
            		
            otherlv_3=(Token)match(input,12,FOLLOW_28); 

            			newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalRobotML.g:1685:3: ( (lv_block_4_0= ruleBlock ) )
            // InternalRobotML.g:1686:4: (lv_block_4_0= ruleBlock )
            {
            // InternalRobotML.g:1686:4: (lv_block_4_0= ruleBlock )
            // InternalRobotML.g:1687:5: lv_block_4_0= ruleBlock
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getBlockBlockParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_19);
            lv_block_4_0=ruleBlock();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					add(
            						current,
            						"block",
            						lv_block_4_0,
            						"org.xtext.robotml.RobotML.Block");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:1704:3: (otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==27) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalRobotML.g:1705:4: otherlv_5= ',' ( (lv_block_6_0= ruleBlock ) )
            	    {
            	    otherlv_5=(Token)match(input,27,FOLLOW_28); 

            	    				newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalRobotML.g:1709:4: ( (lv_block_6_0= ruleBlock ) )
            	    // InternalRobotML.g:1710:5: (lv_block_6_0= ruleBlock )
            	    {
            	    // InternalRobotML.g:1710:5: (lv_block_6_0= ruleBlock )
            	    // InternalRobotML.g:1711:6: lv_block_6_0= ruleBlock
            	    {

            	    						newCompositeNode(grammarAccess.getConditionAccess().getBlockBlockParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_block_6_0=ruleBlock();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"block",
            	    							lv_block_6_0,
            	    							"org.xtext.robotml.RobotML.Block");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_7=(Token)match(input,15,FOLLOW_32); 

            			newLeafNode(otherlv_7, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_6());
            		
            otherlv_8=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_8, grammarAccess.getConditionAccess().getConditionsKeyword_7());
            		
            otherlv_9=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_9, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_8());
            		
            // InternalRobotML.g:1741:3: ( (lv_conditions_10_0= ruleExpression ) )
            // InternalRobotML.g:1742:4: (lv_conditions_10_0= ruleExpression )
            {
            // InternalRobotML.g:1742:4: (lv_conditions_10_0= ruleExpression )
            // InternalRobotML.g:1743:5: lv_conditions_10_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getConditionsExpressionParserRuleCall_9_0());
            				
            pushFollow(FOLLOW_19);
            lv_conditions_10_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					add(
            						current,
            						"conditions",
            						lv_conditions_10_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalRobotML.g:1760:3: (otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==27) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalRobotML.g:1761:4: otherlv_11= ',' ( (lv_conditions_12_0= ruleExpression ) )
            	    {
            	    otherlv_11=(Token)match(input,27,FOLLOW_7); 

            	    				newLeafNode(otherlv_11, grammarAccess.getConditionAccess().getCommaKeyword_10_0());
            	    			
            	    // InternalRobotML.g:1765:4: ( (lv_conditions_12_0= ruleExpression ) )
            	    // InternalRobotML.g:1766:5: (lv_conditions_12_0= ruleExpression )
            	    {
            	    // InternalRobotML.g:1766:5: (lv_conditions_12_0= ruleExpression )
            	    // InternalRobotML.g:1767:6: lv_conditions_12_0= ruleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getConditionAccess().getConditionsExpressionParserRuleCall_10_1_0());
            	    					
            	    pushFollow(FOLLOW_19);
            	    lv_conditions_12_0=ruleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_12_0,
            	    							"org.xtext.robotml.RobotML.Expression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_13=(Token)match(input,15,FOLLOW_8); 

            			newLeafNode(otherlv_13, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_11());
            		
            otherlv_14=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_14, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRulesetSpeed"
    // InternalRobotML.g:1797:1: entryRulesetSpeed returns [EObject current=null] : iv_rulesetSpeed= rulesetSpeed EOF ;
    public final EObject entryRulesetSpeed() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetSpeed = null;


        try {
            // InternalRobotML.g:1797:49: (iv_rulesetSpeed= rulesetSpeed EOF )
            // InternalRobotML.g:1798:2: iv_rulesetSpeed= rulesetSpeed EOF
            {
             newCompositeNode(grammarAccess.getSetSpeedRule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetSpeed=rulesetSpeed();

            state._fsp--;

             current =iv_rulesetSpeed; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetSpeed"


    // $ANTLR start "rulesetSpeed"
    // InternalRobotML.g:1804:1: rulesetSpeed returns [EObject current=null] : (otherlv_0= 'setSpeed' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject rulesetSpeed() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1810:2: ( (otherlv_0= 'setSpeed' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1811:2: (otherlv_0= 'setSpeed' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1811:2: (otherlv_0= 'setSpeed' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:1812:3: otherlv_0= 'setSpeed' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,48,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSetSpeedAccess().getSetSpeedKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSetSpeedAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getSetSpeedAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:1824:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:1825:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:1825:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:1826:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getSetSpeedAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetSpeedRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSetSpeedAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetSpeed"


    // $ANTLR start "entryRuleSetClock"
    // InternalRobotML.g:1851:1: entryRuleSetClock returns [EObject current=null] : iv_ruleSetClock= ruleSetClock EOF ;
    public final EObject entryRuleSetClock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetClock = null;


        try {
            // InternalRobotML.g:1851:49: (iv_ruleSetClock= ruleSetClock EOF )
            // InternalRobotML.g:1852:2: iv_ruleSetClock= ruleSetClock EOF
            {
             newCompositeNode(grammarAccess.getSetClockRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSetClock=ruleSetClock();

            state._fsp--;

             current =iv_ruleSetClock; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetClock"


    // $ANTLR start "ruleSetClock"
    // InternalRobotML.g:1858:1: ruleSetClock returns [EObject current=null] : (otherlv_0= 'SetClock' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleSetClock() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1864:2: ( (otherlv_0= 'SetClock' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1865:2: (otherlv_0= 'SetClock' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1865:2: (otherlv_0= 'SetClock' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:1866:3: otherlv_0= 'SetClock' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,49,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSetClockAccess().getSetClockKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getSetClockAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getSetClockAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:1878:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:1879:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:1879:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:1880:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getSetClockAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSetClockRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSetClockAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetClock"


    // $ANTLR start "entryRuleRotate"
    // InternalRobotML.g:1905:1: entryRuleRotate returns [EObject current=null] : iv_ruleRotate= ruleRotate EOF ;
    public final EObject entryRuleRotate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRotate = null;


        try {
            // InternalRobotML.g:1905:47: (iv_ruleRotate= ruleRotate EOF )
            // InternalRobotML.g:1906:2: iv_ruleRotate= ruleRotate EOF
            {
             newCompositeNode(grammarAccess.getRotateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRotate=ruleRotate();

            state._fsp--;

             current =iv_ruleRotate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRotate"


    // $ANTLR start "ruleRotate"
    // InternalRobotML.g:1912:1: ruleRotate returns [EObject current=null] : (otherlv_0= 'Rotate' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleRotate() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1918:2: ( (otherlv_0= 'Rotate' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1919:2: (otherlv_0= 'Rotate' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1919:2: (otherlv_0= 'Rotate' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:1920:3: otherlv_0= 'Rotate' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRotateAccess().getRotateKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRotateAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getRotateAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:1932:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:1933:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:1933:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:1934:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getRotateAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRotateRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRotateAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRotate"


    // $ANTLR start "entryRuleForward"
    // InternalRobotML.g:1959:1: entryRuleForward returns [EObject current=null] : iv_ruleForward= ruleForward EOF ;
    public final EObject entryRuleForward() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForward = null;


        try {
            // InternalRobotML.g:1959:48: (iv_ruleForward= ruleForward EOF )
            // InternalRobotML.g:1960:2: iv_ruleForward= ruleForward EOF
            {
             newCompositeNode(grammarAccess.getForwardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleForward=ruleForward();

            state._fsp--;

             current =iv_ruleForward; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForward"


    // $ANTLR start "ruleForward"
    // InternalRobotML.g:1966:1: ruleForward returns [EObject current=null] : (otherlv_0= 'Forward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleForward() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:1972:2: ( (otherlv_0= 'Forward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:1973:2: (otherlv_0= 'Forward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:1973:2: (otherlv_0= 'Forward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:1974:3: otherlv_0= 'Forward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getForwardAccess().getForwardKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getForwardAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getForwardAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:1986:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:1987:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:1987:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:1988:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getForwardAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getForwardRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getForwardAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForward"


    // $ANTLR start "entryRuleBackward"
    // InternalRobotML.g:2013:1: entryRuleBackward returns [EObject current=null] : iv_ruleBackward= ruleBackward EOF ;
    public final EObject entryRuleBackward() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBackward = null;


        try {
            // InternalRobotML.g:2013:49: (iv_ruleBackward= ruleBackward EOF )
            // InternalRobotML.g:2014:2: iv_ruleBackward= ruleBackward EOF
            {
             newCompositeNode(grammarAccess.getBackwardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBackward=ruleBackward();

            state._fsp--;

             current =iv_ruleBackward; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBackward"


    // $ANTLR start "ruleBackward"
    // InternalRobotML.g:2020:1: ruleBackward returns [EObject current=null] : (otherlv_0= 'Backward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleBackward() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:2026:2: ( (otherlv_0= 'Backward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:2027:2: (otherlv_0= 'Backward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:2027:2: (otherlv_0= 'Backward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:2028:3: otherlv_0= 'Backward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getBackwardAccess().getBackwardKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getBackwardAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getBackwardAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:2040:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:2041:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:2041:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:2042:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getBackwardAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getBackwardRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getBackwardAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBackward"


    // $ANTLR start "entryRuleLeftward"
    // InternalRobotML.g:2067:1: entryRuleLeftward returns [EObject current=null] : iv_ruleLeftward= ruleLeftward EOF ;
    public final EObject entryRuleLeftward() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLeftward = null;


        try {
            // InternalRobotML.g:2067:49: (iv_ruleLeftward= ruleLeftward EOF )
            // InternalRobotML.g:2068:2: iv_ruleLeftward= ruleLeftward EOF
            {
             newCompositeNode(grammarAccess.getLeftwardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLeftward=ruleLeftward();

            state._fsp--;

             current =iv_ruleLeftward; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLeftward"


    // $ANTLR start "ruleLeftward"
    // InternalRobotML.g:2074:1: ruleLeftward returns [EObject current=null] : (otherlv_0= 'Leftward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleLeftward() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:2080:2: ( (otherlv_0= 'Leftward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:2081:2: (otherlv_0= 'Leftward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:2081:2: (otherlv_0= 'Leftward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:2082:3: otherlv_0= 'Leftward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLeftwardAccess().getLeftwardKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getLeftwardAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getLeftwardAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:2094:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:2095:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:2095:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:2096:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getLeftwardAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLeftwardRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getLeftwardAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLeftward"


    // $ANTLR start "entryRuleRightward"
    // InternalRobotML.g:2121:1: entryRuleRightward returns [EObject current=null] : iv_ruleRightward= ruleRightward EOF ;
    public final EObject entryRuleRightward() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRightward = null;


        try {
            // InternalRobotML.g:2121:50: (iv_ruleRightward= ruleRightward EOF )
            // InternalRobotML.g:2122:2: iv_ruleRightward= ruleRightward EOF
            {
             newCompositeNode(grammarAccess.getRightwardRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRightward=ruleRightward();

            state._fsp--;

             current =iv_ruleRightward; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRightward"


    // $ANTLR start "ruleRightward"
    // InternalRobotML.g:2128:1: ruleRightward returns [EObject current=null] : (otherlv_0= 'Rightward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) ;
    public final EObject ruleRightward() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_expression_3_0 = null;



        	enterRule();

        try {
            // InternalRobotML.g:2134:2: ( (otherlv_0= 'Rightward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' ) )
            // InternalRobotML.g:2135:2: (otherlv_0= 'Rightward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            {
            // InternalRobotML.g:2135:2: (otherlv_0= 'Rightward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}' )
            // InternalRobotML.g:2136:3: otherlv_0= 'Rightward' otherlv_1= '{' otherlv_2= 'expression' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,54,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRightwardAccess().getRightwardKeyword_0());
            		
            otherlv_1=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getRightwardAccess().getLeftCurlyBracketKeyword_1());
            		
            otherlv_2=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getRightwardAccess().getExpressionKeyword_2());
            		
            // InternalRobotML.g:2148:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalRobotML.g:2149:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalRobotML.g:2149:4: (lv_expression_3_0= ruleExpression )
            // InternalRobotML.g:2150:5: lv_expression_3_0= ruleExpression
            {

            					newCompositeNode(grammarAccess.getRightwardAccess().getExpressionExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_expression_3_0=ruleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRightwardRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_3_0,
            						"org.xtext.robotml.RobotML.Expression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,15,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getRightwardAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRightward"


    // $ANTLR start "ruleBinaryOp"
    // InternalRobotML.g:2175:1: ruleBinaryOp returns [Enumerator current=null] : ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'NOT' ) | (enumLiteral_3= 'EQUAL' ) | (enumLiteral_4= 'LESSOREQUAL' ) | (enumLiteral_5= 'GREATEROREQUAL' ) | (enumLiteral_6= 'LESS' ) | (enumLiteral_7= 'GREATER' ) | (enumLiteral_8= 'PLUS' ) | (enumLiteral_9= 'MINUS' ) | (enumLiteral_10= 'TIMES' ) | (enumLiteral_11= 'DIVIDE' ) | (enumLiteral_12= 'MODULO' ) ) ;
    public final Enumerator ruleBinaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;


        	enterRule();

        try {
            // InternalRobotML.g:2181:2: ( ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'NOT' ) | (enumLiteral_3= 'EQUAL' ) | (enumLiteral_4= 'LESSOREQUAL' ) | (enumLiteral_5= 'GREATEROREQUAL' ) | (enumLiteral_6= 'LESS' ) | (enumLiteral_7= 'GREATER' ) | (enumLiteral_8= 'PLUS' ) | (enumLiteral_9= 'MINUS' ) | (enumLiteral_10= 'TIMES' ) | (enumLiteral_11= 'DIVIDE' ) | (enumLiteral_12= 'MODULO' ) ) )
            // InternalRobotML.g:2182:2: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'NOT' ) | (enumLiteral_3= 'EQUAL' ) | (enumLiteral_4= 'LESSOREQUAL' ) | (enumLiteral_5= 'GREATEROREQUAL' ) | (enumLiteral_6= 'LESS' ) | (enumLiteral_7= 'GREATER' ) | (enumLiteral_8= 'PLUS' ) | (enumLiteral_9= 'MINUS' ) | (enumLiteral_10= 'TIMES' ) | (enumLiteral_11= 'DIVIDE' ) | (enumLiteral_12= 'MODULO' ) )
            {
            // InternalRobotML.g:2182:2: ( (enumLiteral_0= 'AND' ) | (enumLiteral_1= 'OR' ) | (enumLiteral_2= 'NOT' ) | (enumLiteral_3= 'EQUAL' ) | (enumLiteral_4= 'LESSOREQUAL' ) | (enumLiteral_5= 'GREATEROREQUAL' ) | (enumLiteral_6= 'LESS' ) | (enumLiteral_7= 'GREATER' ) | (enumLiteral_8= 'PLUS' ) | (enumLiteral_9= 'MINUS' ) | (enumLiteral_10= 'TIMES' ) | (enumLiteral_11= 'DIVIDE' ) | (enumLiteral_12= 'MODULO' ) )
            int alt20=13;
            switch ( input.LA(1) ) {
            case 55:
                {
                alt20=1;
                }
                break;
            case 56:
                {
                alt20=2;
                }
                break;
            case 57:
                {
                alt20=3;
                }
                break;
            case 58:
                {
                alt20=4;
                }
                break;
            case 59:
                {
                alt20=5;
                }
                break;
            case 60:
                {
                alt20=6;
                }
                break;
            case 61:
                {
                alt20=7;
                }
                break;
            case 62:
                {
                alt20=8;
                }
                break;
            case 63:
                {
                alt20=9;
                }
                break;
            case 64:
                {
                alt20=10;
                }
                break;
            case 65:
                {
                alt20=11;
                }
                break;
            case 66:
                {
                alt20=12;
                }
                break;
            case 67:
                {
                alt20=13;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalRobotML.g:2183:3: (enumLiteral_0= 'AND' )
                    {
                    // InternalRobotML.g:2183:3: (enumLiteral_0= 'AND' )
                    // InternalRobotML.g:2184:4: enumLiteral_0= 'AND'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getANDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getBinaryOpAccess().getANDEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRobotML.g:2191:3: (enumLiteral_1= 'OR' )
                    {
                    // InternalRobotML.g:2191:3: (enumLiteral_1= 'OR' )
                    // InternalRobotML.g:2192:4: enumLiteral_1= 'OR'
                    {
                    enumLiteral_1=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getOREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getBinaryOpAccess().getOREnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalRobotML.g:2199:3: (enumLiteral_2= 'NOT' )
                    {
                    // InternalRobotML.g:2199:3: (enumLiteral_2= 'NOT' )
                    // InternalRobotML.g:2200:4: enumLiteral_2= 'NOT'
                    {
                    enumLiteral_2=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getNOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getBinaryOpAccess().getNOTEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalRobotML.g:2207:3: (enumLiteral_3= 'EQUAL' )
                    {
                    // InternalRobotML.g:2207:3: (enumLiteral_3= 'EQUAL' )
                    // InternalRobotML.g:2208:4: enumLiteral_3= 'EQUAL'
                    {
                    enumLiteral_3=(Token)match(input,58,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getEQUALEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getBinaryOpAccess().getEQUALEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalRobotML.g:2215:3: (enumLiteral_4= 'LESSOREQUAL' )
                    {
                    // InternalRobotML.g:2215:3: (enumLiteral_4= 'LESSOREQUAL' )
                    // InternalRobotML.g:2216:4: enumLiteral_4= 'LESSOREQUAL'
                    {
                    enumLiteral_4=(Token)match(input,59,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getLESSOREQUALEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getBinaryOpAccess().getLESSOREQUALEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalRobotML.g:2223:3: (enumLiteral_5= 'GREATEROREQUAL' )
                    {
                    // InternalRobotML.g:2223:3: (enumLiteral_5= 'GREATEROREQUAL' )
                    // InternalRobotML.g:2224:4: enumLiteral_5= 'GREATEROREQUAL'
                    {
                    enumLiteral_5=(Token)match(input,60,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getGREATEROREQUALEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getBinaryOpAccess().getGREATEROREQUALEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalRobotML.g:2231:3: (enumLiteral_6= 'LESS' )
                    {
                    // InternalRobotML.g:2231:3: (enumLiteral_6= 'LESS' )
                    // InternalRobotML.g:2232:4: enumLiteral_6= 'LESS'
                    {
                    enumLiteral_6=(Token)match(input,61,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getLESSEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getBinaryOpAccess().getLESSEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;
                case 8 :
                    // InternalRobotML.g:2239:3: (enumLiteral_7= 'GREATER' )
                    {
                    // InternalRobotML.g:2239:3: (enumLiteral_7= 'GREATER' )
                    // InternalRobotML.g:2240:4: enumLiteral_7= 'GREATER'
                    {
                    enumLiteral_7=(Token)match(input,62,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getGREATEREnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_7, grammarAccess.getBinaryOpAccess().getGREATEREnumLiteralDeclaration_7());
                    			

                    }


                    }
                    break;
                case 9 :
                    // InternalRobotML.g:2247:3: (enumLiteral_8= 'PLUS' )
                    {
                    // InternalRobotML.g:2247:3: (enumLiteral_8= 'PLUS' )
                    // InternalRobotML.g:2248:4: enumLiteral_8= 'PLUS'
                    {
                    enumLiteral_8=(Token)match(input,63,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getPLUSEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_8, grammarAccess.getBinaryOpAccess().getPLUSEnumLiteralDeclaration_8());
                    			

                    }


                    }
                    break;
                case 10 :
                    // InternalRobotML.g:2255:3: (enumLiteral_9= 'MINUS' )
                    {
                    // InternalRobotML.g:2255:3: (enumLiteral_9= 'MINUS' )
                    // InternalRobotML.g:2256:4: enumLiteral_9= 'MINUS'
                    {
                    enumLiteral_9=(Token)match(input,64,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getMINUSEnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_9, grammarAccess.getBinaryOpAccess().getMINUSEnumLiteralDeclaration_9());
                    			

                    }


                    }
                    break;
                case 11 :
                    // InternalRobotML.g:2263:3: (enumLiteral_10= 'TIMES' )
                    {
                    // InternalRobotML.g:2263:3: (enumLiteral_10= 'TIMES' )
                    // InternalRobotML.g:2264:4: enumLiteral_10= 'TIMES'
                    {
                    enumLiteral_10=(Token)match(input,65,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getTIMESEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_10, grammarAccess.getBinaryOpAccess().getTIMESEnumLiteralDeclaration_10());
                    			

                    }


                    }
                    break;
                case 12 :
                    // InternalRobotML.g:2271:3: (enumLiteral_11= 'DIVIDE' )
                    {
                    // InternalRobotML.g:2271:3: (enumLiteral_11= 'DIVIDE' )
                    // InternalRobotML.g:2272:4: enumLiteral_11= 'DIVIDE'
                    {
                    enumLiteral_11=(Token)match(input,66,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getDIVIDEEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_11, grammarAccess.getBinaryOpAccess().getDIVIDEEnumLiteralDeclaration_11());
                    			

                    }


                    }
                    break;
                case 13 :
                    // InternalRobotML.g:2279:3: (enumLiteral_12= 'MODULO' )
                    {
                    // InternalRobotML.g:2279:3: (enumLiteral_12= 'MODULO' )
                    // InternalRobotML.g:2280:4: enumLiteral_12= 'MODULO'
                    {
                    enumLiteral_12=(Token)match(input,67,FOLLOW_2); 

                    				current = grammarAccess.getBinaryOpAccess().getMODULOEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_12, grammarAccess.getBinaryOpAccess().getMODULOEnumLiteralDeclaration_12());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinaryOp"


    // $ANTLR start "ruleUnaryOp"
    // InternalRobotML.g:2290:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= 'NOTEQUAL' ) | (enumLiteral_1= 'NEGATE' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:2296:2: ( ( (enumLiteral_0= 'NOTEQUAL' ) | (enumLiteral_1= 'NEGATE' ) ) )
            // InternalRobotML.g:2297:2: ( (enumLiteral_0= 'NOTEQUAL' ) | (enumLiteral_1= 'NEGATE' ) )
            {
            // InternalRobotML.g:2297:2: ( (enumLiteral_0= 'NOTEQUAL' ) | (enumLiteral_1= 'NEGATE' ) )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==68) ) {
                alt21=1;
            }
            else if ( (LA21_0==69) ) {
                alt21=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalRobotML.g:2298:3: (enumLiteral_0= 'NOTEQUAL' )
                    {
                    // InternalRobotML.g:2298:3: (enumLiteral_0= 'NOTEQUAL' )
                    // InternalRobotML.g:2299:4: enumLiteral_0= 'NOTEQUAL'
                    {
                    enumLiteral_0=(Token)match(input,68,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOpAccess().getNOTEQUALEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getNOTEQUALEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRobotML.g:2306:3: (enumLiteral_1= 'NEGATE' )
                    {
                    // InternalRobotML.g:2306:3: (enumLiteral_1= 'NEGATE' )
                    // InternalRobotML.g:2307:4: enumLiteral_1= 'NEGATE'
                    {
                    enumLiteral_1=(Token)match(input,69,FOLLOW_2); 

                    				current = grammarAccess.getUnaryOpAccess().getNEGATEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getNEGATEEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "ruleSensor"
    // InternalRobotML.g:2317:1: ruleSensor returns [Enumerator current=null] : ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Color' ) ) ;
    public final Enumerator ruleSensor() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalRobotML.g:2323:2: ( ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Color' ) ) )
            // InternalRobotML.g:2324:2: ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Color' ) )
            {
            // InternalRobotML.g:2324:2: ( (enumLiteral_0= 'Distance' ) | (enumLiteral_1= 'Color' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==70) ) {
                alt22=1;
            }
            else if ( (LA22_0==71) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalRobotML.g:2325:3: (enumLiteral_0= 'Distance' )
                    {
                    // InternalRobotML.g:2325:3: (enumLiteral_0= 'Distance' )
                    // InternalRobotML.g:2326:4: enumLiteral_0= 'Distance'
                    {
                    enumLiteral_0=(Token)match(input,70,FOLLOW_2); 

                    				current = grammarAccess.getSensorAccess().getDistanceEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSensorAccess().getDistanceEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalRobotML.g:2333:3: (enumLiteral_1= 'Color' )
                    {
                    // InternalRobotML.g:2333:3: (enumLiteral_1= 'Color' )
                    // InternalRobotML.g:2334:4: enumLiteral_1= 'Color'
                    {
                    enumLiteral_1=(Token)match(input,71,FOLLOW_2); 

                    				current = grammarAccess.getSensorAccess().getColorEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSensorAccess().getColorEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSensor"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x000000EA40800000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x00000000007C0000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000022000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000018000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x00000000A0000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0xFF80000000000000L,0x000000000000000FL});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000030L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000010020000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000200000008000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x007F520000810800L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000800000000000L});

}