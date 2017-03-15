<?xml version="1.0" encoding="UTF-8"?><xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/ObjectData/Object[@CCID='新闻节目类']">
        <MetaData>
            <xsl:for-each select="Object[@CCID='片段子类']/MetaData">
                <Sequence>
            <Title>
                <ProperTitle>
                    <xsl:value-of select="MetaData.Sequence.Title.ProperTitle"/>
                </ProperTitle>
                <xsl:for-each select="sAttribute[@strName='并列正题名']">
                    <ParallelProperTitle>
                        <xsl:value-of select="MetaData.Sequence.Title.ParallelProperTitle"/>
                    </ParallelProperTitle>
                </xsl:for-each>
                <SeriesTitle>
                    <xsl:value-of select="MetaData.Sequence.Title.SeriesTitle"/>
                </SeriesTitle>
            </Title>
            <Subject>
                <xsl:for-each select="sAttribute[@strName='分类名']">
                    <Class>
                        <Classification>未知</Classification>
                        <ClassNumber>
                            <xsl:value-of select="MetaData.Sequence.Subject.Class.ClassNumber"/>
                        </ClassNumber>
                    </Class>
                </xsl:for-each>
                <xsl:for-each select="sAttribute[@strName='主题词']">
                    <SubjectTerm>
                        <xsl:value-of select="MetaData.Sequence.Subject.SubjectTerm"/>
                    </SubjectTerm>
                </xsl:for-each>
                <xsl:for-each select="sAttribute[@strName='关键词']">
                    <Keyword>
                        <xsl:value-of select="MetaData.Sequence.Subject.Keyword"/>
                    </Keyword>
                </xsl:for-each>
            </Subject>
            <Description>
                <DescriptionofContent>
                    <xsl:value-of select="MetaData.Sequence.Description.DescriptionofContent"/>
                </DescriptionofContent>
                <DateofEvent>
                    <xsl:value-of select="MetaData.Sequence.Description.DateofEvent"/>
                </DateofEvent>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='获奖']">
                    <xsl:for-each select="MetaData">
                        <Awards>
                            <NameofAwards>
                                <xsl:value-of select="CMS.MetaData.Description.Awards.NameofAwards"/>
                            </NameofAwards>
                            <ItemofAwards>
                                <xsl:value-of select="CMS.MetaData.Description.Awards.ItemofAwards"/>
                            </ItemofAwards>
                            <xsl:for-each select="sAttribute[@strName='获奖者']">
                                <WinnersofAwards>
                                    <xsl:value-of select="CMS.MetaData.Description.Awards.WinnersofAwards"/>
                                </WinnersofAwards>
                            </xsl:for-each>
                            <YearorTimeofAwards>
                                <xsl:value-of select="CMS.MetaData.Description.Awards.YearorTimeofAwards"/>
                            </YearorTimeofAwards>
                            <DateofAwards>
                                <xsl:value-of select="CMS.MetaData.Description.Awards.DateofAwards"/>
                            </DateofAwards>
                        </Awards>
                    </xsl:for-each>
                </xsl:for-each>
                <NaturalSound>
                    <xsl:value-of select="MetaData.Sequence.Description.NaturalSound"/>
                </NaturalSound>
            </Description>
            <Creator>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='创建者']">
                    <xsl:for-each select="MetaData">
                        <DescriptionofCreator>
                            <NameofCreator>
                                <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.NameofCreator"/>
                            </NameofCreator>
                            <xsl:for-each select="sAttribute[@strName='创建者并列名']">
                                <ParallelNameofCreator>
                                    <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.ParallelNameofCreator"/>
                                </ParallelNameofCreator>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="MetaData.Sequence.Creator.DescriptionofCreator.OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofCreator>
                    </xsl:for-each>
                </xsl:for-each>
            </Creator>
            <Contributor>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='责任者描述（片段）']">
                    <xsl:for-each select="MetaData">
                        <DescriptionofContributor>
                            <NameofContributor>
                                <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.NameofContributor"/>
                            </NameofContributor>
                            <xsl:for-each select="sAttribute[@strName='责任者并列名']">
                                <ParallelNameofContributor>
                                    <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.ParallelNameofContributor"/>
                                </ParallelNameofContributor>
                            </xsl:for-each>
                            <Role>
                                <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.Role"/>
                            </Role>
                            <OtherInformation>
                                <xsl:value-of select="MetaData.Sequence.Contributor.DescriptionofContributor.OtherInformation"/>
                            </OtherInformation>
                        </DescriptionofContributor>
                    </xsl:for-each>
                </xsl:for-each>
            </Contributor>
            <Copyright>
                <xsl:for-each select="Copyright/DescriptionofAuthorizedUse">
                    <DescriptionofAuthorizedUse>
                        <TimesofAuthorizedUsage>
                            <xsl:value-of select="MetaData.Sequence.Copyright.DescriptionofAuthorizedUse.TimesofAuthorizedUsage"/>
                        </TimesofAuthorizedUsage>
                    </DescriptionofAuthorizedUse>
                </xsl:for-each>
            </Copyright>
            <Language>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='声道语种描述']">
                    <xsl:for-each select="MetaData">
                        <AudioChannel>
                            <AudioChannelNumber>
                                <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelNumber"/>
                            </AudioChannelNumber>
                            <AudioChannelLanguage>
                                <xsl:value-of select="MetaData.Sequence.Language.AudioChannel.AudioChannelLanguage"/>
                            </AudioChannelLanguage>
                        </AudioChannel>
                    </xsl:for-each>

                </xsl:for-each>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='字幕语种描述']">
                    <xsl:for-each select="MetaData">
                        <Subtitle>
                            <SubtitleNumber>
                                <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleNumber"/>
                            </SubtitleNumber>
                            <SubtitleLanguage>
                                <xsl:value-of select="MetaData.Sequence.Language.Subtitle.SubtitleLanguage"/>
                            </SubtitleLanguage>
                        </Subtitle>
                    </xsl:for-each>
                </xsl:for-each>
            </Language>
            <Type>
                <xsl:for-each select="sAttribute[@strName='节目形态']">
                    <ProgramForm>
                        <xsl:value-of select="MetaData.Sequence.Type.ProgramForm"/>
                    </ProgramForm>
                </xsl:for-each>
            </Type>
            <Format>
                <Duration>
                    <xsl:value-of select="CMS.MetaData.Clip.ClipBaseInfo.Duration"/>
                </Duration>
                <StartingPoint>
                    <xsl:value-of select="MetaData.Sequence.Format.StartingPoint"/>
                </StartingPoint>
                <SubtitleForm>
                    <xsl:value-of select="MetaData.Sequence.Format.SubtitleForm"/>
                </SubtitleForm>
            </Format>
            <Coverage>
                <xsl:for-each select="sAttributeGroups/sAttributeGroup[@Name='时间范围']">
                    <xsl:for-each select="MetaData">
                        <YearofStart>
                            <xsl:value-of select="MetaData.Sequence.Coverage.YearofStart"/>
                        </YearofStart>
                        <YearofEnd>
                            <xsl:value-of select="MetaData.Sequence.Coverage.YearofEnd"/>
                        </YearofEnd>
                        <DescriptionofYearsCovered>
                            <xsl:value-of select="MetaData.Sequence.Coverage.DescriptionofYearsCovered"/>
                        </DescriptionofYearsCovered>
                    </xsl:for-each>
                </xsl:for-each>
                <xsl:for-each select="sAttribute[@strName='空间范围']">
                    <Spatial>
                        <xsl:value-of select="MetaData.Sequence.Coverage.Spatial"/>
                    </Spatial>
                </xsl:for-each>
            </Coverage>
        </Sequence>
            </xsl:for-each>
        </MetaData>
    </xsl:template>
    <xsl:template match="text()"/>
</xsl:stylesheet>